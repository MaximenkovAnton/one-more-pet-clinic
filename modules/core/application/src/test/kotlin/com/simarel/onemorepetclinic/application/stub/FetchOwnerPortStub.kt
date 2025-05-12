package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchOwnerPortStub : FetchOwnerPort {
    private val owners = mutableMapOf<OwnerId, Owner>()

    init {
        val owner1 = DomainObjectFactory.createOwner(
            firstName = ValueObjectFactory.createFirstName("Иван"),
            lastName = ValueObjectFactory.createLastName("Иванов")
        )
        val owner2 = DomainObjectFactory.createOwner(
            firstName = ValueObjectFactory.createFirstName("Петр"),
            lastName = ValueObjectFactory.createLastName("Петров")
        )
        val owner3 = DomainObjectFactory.createOwner(
            firstName = ValueObjectFactory.createFirstName("Сергей"),
            lastName = ValueObjectFactory.createLastName("Сергеев")
        )

        owners[owner1.id] = owner1
        owners[owner2.id] = owner2
        owners[owner3.id] = owner3
    }

    override fun invoke(request: FetchOwnerRequest): FetchOwnerResponse {
        return FetchOwnerResponse(owners[request.id])
    }

    fun getOwners(): Map<OwnerId, Owner> = owners.toMap()

    fun getOwnerById(id: OwnerId): Owner? = owners[id]

    fun addOwner(owner: Owner) {
        owners[owner.id] = owner
    }
}
