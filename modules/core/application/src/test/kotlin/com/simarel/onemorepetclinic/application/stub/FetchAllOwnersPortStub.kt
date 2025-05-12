package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersPort
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersRequest
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchAllOwnersPortStub : FetchAllOwnersPort {
    private val owners = mutableMapOf<OwnerId, Owner>()
    private var lastPaginationInfo: PaginationInfo? = null

    init {
        for (i in 1..10) {
            val owner = DomainObjectFactory.createOwner(
                firstName = ValueObjectFactory.createFirstName("Имя$i"),
                lastName = ValueObjectFactory.createLastName("Фамилия$i")
            )
            owners[owner.id] = owner
        }
    }

    override fun invoke(request: FetchAllOwnersRequest): FetchAllOwnersResponse {
        lastPaginationInfo = request.paginationInfo

        val pageNumber = request.paginationInfo.pageNumber.value
        val pageSize = request.paginationInfo.pageSize.value
        val startIndex = pageNumber * pageSize
        val endIndex = startIndex + pageSize

        val ownersList = owners.values.toList()
        val pagedOwners = if (startIndex < ownersList.size) {
            ownersList.subList(startIndex, minOf(endIndex, ownersList.size))
        } else {
            emptyList()
        }

        return FetchAllOwnersResponse(
            owners = pagedOwners,
            count = Count.of(owners.size.toLong())
        )
    }

    fun getLastPaginationInfo(): PaginationInfo? = lastPaginationInfo

    fun getOwners(): Map<OwnerId, Owner> = owners.toMap()

    fun addOwner(owner: Owner) {
        owners[owner.id] = owner
    }

    fun removeOwner(id: OwnerId) {
        owners.remove(id)
    }
}
