package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerResponse

class SaveOwnerPortStub : SaveOwnerPort {
    private val owners = mutableMapOf<OwnerId, Owner>()
    private var lastSavedOwner: Owner? = null

    override fun invoke(request: SaveOwnerRequest): SaveOwnerResponse {
        val owner = request.owner
        owners[owner.id] = owner
        lastSavedOwner = owner
        return SaveOwnerResponse(owner)
    }

    fun getLastSavedOwner(): Owner? = lastSavedOwner

    fun getOwners(): Map<OwnerId, Owner> = owners.toMap()

    fun getOwnerById(id: OwnerId): Owner? = owners[id]
}
