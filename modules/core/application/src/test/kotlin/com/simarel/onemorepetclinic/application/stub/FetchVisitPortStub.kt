package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitPort
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import java.time.LocalDate

class FetchVisitPortStub : FetchVisitPort {
    private val visits = mutableMapOf<VisitId, Visit>()

    init {
        // Создаем несколько визитов при инициализации
        val pet1 = DomainObjectFactory.createPet()
        val pet2 = DomainObjectFactory.createPet()

        val visit1 = DomainObjectFactory.createVisit(
            id = IdFactory.createVisitId(),
            date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(1)),
            description = ValueObjectFactory.createDescription("Ежегодный осмотр"),
            pet = pet1
        )
        val visit2 = DomainObjectFactory.createVisit(
            id = IdFactory.createVisitId(),
            date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(2)),
            description = ValueObjectFactory.createDescription("Вакцинация"),
            pet = pet1
        )
        val visit3 = DomainObjectFactory.createVisit(
            id = IdFactory.createVisitId(),
            date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(3)),
            description = ValueObjectFactory.createDescription("Стерилизация"),
            pet = pet2
        )

        visits[visit1.id] = visit1
        visits[visit2.id] = visit2
        visits[visit3.id] = visit3
    }

    override fun invoke(request: FetchVisitRequest): FetchVisitResponse {
        return FetchVisitResponse(visits[request.id])
    }

    fun getVisits(): Map<VisitId, Visit> = visits.toMap()

    fun getVisitById(id: VisitId): Visit? = visits[id]

    fun addVisit(visit: Visit) {
        visits[visit.id] = visit
    }
}
