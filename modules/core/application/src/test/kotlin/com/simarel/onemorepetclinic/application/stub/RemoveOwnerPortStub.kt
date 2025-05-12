package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerResponse

class RemoveOwnerPortStub : RemoveOwnerPort {
    private val removedOwnerIds = mutableListOf<OwnerId>()
    private var lastRemovedOwnerId: OwnerId? = null

    override fun invoke(request: RemoveOwnerRequest): RemoveOwnerResponse {
        val ownerId = request.id
        removedOwnerIds.add(ownerId)
        lastRemovedOwnerId = ownerId
        return RemoveOwnerResponse()
    }

    fun getLastRemovedOwnerId(): OwnerId? = lastRemovedOwnerId

    fun getRemovedOwnerIds(): List<OwnerId> = removedOwnerIds.toList()

    fun wasOwnerRemoved(id: OwnerId): Boolean = removedOwnerIds.contains(id)
}
