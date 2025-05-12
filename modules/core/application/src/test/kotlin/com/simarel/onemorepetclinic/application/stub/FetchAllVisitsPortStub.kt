package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsPort
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsRequest
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import java.time.LocalDate

class FetchAllVisitsPortStub : FetchAllVisitsPort {
    private val visits = mutableMapOf<VisitId, Visit>()
    private val visitsByPet = mutableMapOf<PetId, MutableList<Visit>>()
    private var lastPaginationInfo: PaginationInfo? = null
    private var lastPetId: PetId? = null

    init {
        // Создаем несколько питомцев и их визитов при инициализации
        val pet1 = DomainObjectFactory.createPet(id = IdFactory.createPetId())
        val pet2 = DomainObjectFactory.createPet(id = IdFactory.createPetId())

        // Визиты первого питомца
        val pet1Visits = mutableListOf<Visit>()
        for (i in 1..3) {
            val visit = DomainObjectFactory.createVisit(
                id = IdFactory.createVisitId(),
                date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(i.toLong())),
                description = ValueObjectFactory.createDescription("Визит $i для питомца 1"),
                pet = pet1
            )
            visits[visit.id] = visit
            pet1Visits.add(visit)
        }
        visitsByPet[pet1.id] = pet1Visits

        // Визиты второго питомца
        val pet2Visits = mutableListOf<Visit>()
        for (i in 1..2) {
            val visit = DomainObjectFactory.createVisit(
                id = IdFactory.createVisitId(),
                date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays((i + 3).toLong())),
                description = ValueObjectFactory.createDescription("Визит $i для питомца 2"),
                pet = pet2
            )
            visits[visit.id] = visit
            pet2Visits.add(visit)
        }
        visitsByPet[pet2.id] = pet2Visits
    }

    override fun invoke(request: FetchAllVisitsRequest): FetchAllVisitsResponse {
        lastPaginationInfo = request.paginationInfo
        lastPetId = request.petId

        val pageNumber = request.paginationInfo.pageNumber.value
        val pageSize = request.paginationInfo.pageSize.value
        val startIndex = pageNumber * pageSize
        val endIndex = startIndex + pageSize

        val filteredVisits = if (request.petId != null) {
            visitsByPet[request.petId]?.toList() ?: emptyList()
        } else {
            visits.values.toList()
        }

        val pagedVisits = if (startIndex < filteredVisits.size) {
            filteredVisits.subList(startIndex, minOf(endIndex, filteredVisits.size))
        } else {
            emptyList()
        }

        return FetchAllVisitsResponse(
            visits = pagedVisits,
            count = Count.of(filteredVisits.size.toLong())
        )
    }

    fun getLastPaginationInfo(): PaginationInfo? = lastPaginationInfo

    fun getLastPetId(): PetId? = lastPetId

    fun getVisits(): Map<VisitId, Visit> = visits.toMap()

    fun getVisitsByPet(petId: PetId): List<Visit> = visitsByPet[petId]?.toList() ?: emptyList()

    fun addVisit(visit: Visit) {
        visits[visit.id] = visit
        visitsByPet.getOrPut(visit.pet.id) { mutableListOf() }.add(visit)
    }

    fun removeVisit(id: VisitId) {
        val visit = visits[id] ?: return
        visits.remove(id)
        visitsByPet[visit.pet.id]?.remove(visit)
    }
}
