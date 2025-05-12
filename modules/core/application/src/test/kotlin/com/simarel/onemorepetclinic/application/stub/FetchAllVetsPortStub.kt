package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsPort
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsRequest
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchAllVetsPortStub : FetchAllVetsPort {
    private val vets = mutableMapOf<VetId, Vet>()
    private val vetsBySpeciality = mutableMapOf<String, MutableList<Vet>>()
    private var lastPaginationInfo: PaginationInfo? = null
    private var lastSpeciality: Speciality? = null

    init {
        // Создаем несколько ветеринаров при инициализации
        val specialities = listOf("Хирургия", "Терапия", "Кардиология", "Дерматология", "Офтальмология")

        for (i in 1..5) {
            val vetSpecialities = mutableSetOf<Speciality>()
            // Добавляем 1-2 специальности каждому ветеринару
            val specialityCount = (1..2).random()
            for (j in 0 until specialityCount) {
                val specialityIndex = (specialities.indices).random()
                vetSpecialities.add(ValueObjectFactory.createSpeciality(specialities[specialityIndex]))
            }

            val vet = DomainObjectFactory.createVet(
                id = IdFactory.createVetId(),
                firstName = ValueObjectFactory.createFirstName("Имя$i"),
                lastName = ValueObjectFactory.createLastName("Фамилия$i"),
                specialities = vetSpecialities
            )

            vets[vet.id] = vet

            // Добавляем ветеринара в списки по специальностям
            for (speciality in vetSpecialities) {
                vetsBySpeciality.getOrPut(speciality.value) { mutableListOf() }.add(vet)
            }
        }
    }

    override fun invoke(request: FetchAllVetsRequest): FetchAllVetsResponse {
        lastPaginationInfo = request.paginationInfo
        lastSpeciality = request.speciality

        val pageNumber = request.paginationInfo.pageNumber.value
        val pageSize = request.paginationInfo.pageSize.value
        val startIndex = pageNumber * pageSize
        val endIndex = startIndex + pageSize

        val filteredVets = if (request.speciality != null) {
            vetsBySpeciality[request.speciality!!.value]?.toList() ?: emptyList()
        } else {
            vets.values.toList()
        }

        val pagedVets = if (startIndex < filteredVets.size) {
            filteredVets.subList(startIndex, minOf(endIndex, filteredVets.size))
        } else {
            emptyList()
        }

        return FetchAllVetsResponse(
            vets = pagedVets,
            count = Count.of(filteredVets.size.toLong())
        )
    }

    fun getLastPaginationInfo(): PaginationInfo? = lastPaginationInfo

    fun getLastSpeciality(): Speciality? = lastSpeciality

    fun getVets(): Map<VetId, Vet> = vets.toMap()

    fun getVetsBySpeciality(speciality: Speciality): List<Vet> = vetsBySpeciality[speciality.value]?.toList() ?: emptyList()

    fun addVet(vet: Vet) {
        vets[vet.id] = vet
        for (speciality in vet.specialities) {
            vetsBySpeciality.getOrPut(speciality.value) { mutableListOf() }.add(vet)
        }
    }

    fun removeVet(id: VetId) {
        val vet = vets[id] ?: return
        vets.remove(id)
        for (speciality in vet.specialities) {
            vetsBySpeciality[speciality.value]?.remove(vet)
        }
    }
}
