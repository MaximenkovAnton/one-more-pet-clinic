package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.output.vet.FetchVetPort
import com.simarel.onemorepetclinic.port.output.vet.FetchVetRequest
import com.simarel.onemorepetclinic.port.output.vet.FetchVetResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchVetPortStub : FetchVetPort {
    private val vets = mutableMapOf<VetId, Vet>()

    init {
        // Создаем несколько ветеринаров при инициализации
        val vet1 = DomainObjectFactory.createVet(
            id = IdFactory.createVetId(),
            firstName = ValueObjectFactory.createFirstName("Иван"),
            lastName = ValueObjectFactory.createLastName("Иванов"),
            specialities = setOf(
                ValueObjectFactory.createSpeciality("Хирургия"),
                ValueObjectFactory.createSpeciality("Терапия")
            )
        )
        val vet2 = DomainObjectFactory.createVet(
            id = IdFactory.createVetId(),
            firstName = ValueObjectFactory.createFirstName("Петр"),
            lastName = ValueObjectFactory.createLastName("Петров"),
            specialities = setOf(
                ValueObjectFactory.createSpeciality("Кардиология")
            )
        )
        val vet3 = DomainObjectFactory.createVet(
            id = IdFactory.createVetId(),
            firstName = ValueObjectFactory.createFirstName("Сергей"),
            lastName = ValueObjectFactory.createLastName("Сергеев"),
            specialities = setOf(
                ValueObjectFactory.createSpeciality("Дерматология"),
                ValueObjectFactory.createSpeciality("Офтальмология")
            )
        )

        vets[vet1.id] = vet1
        vets[vet2.id] = vet2
        vets[vet3.id] = vet3
    }

    override fun invoke(request: FetchVetRequest): FetchVetResponse {
        return FetchVetResponse(vets[request.id])
    }

    fun getVets(): Map<VetId, Vet> = vets.toMap()

    fun getVetById(id: VetId): Vet? = vets[id]

    fun addVet(vet: Vet) {
        vets[vet.id] = vet
    }
}
