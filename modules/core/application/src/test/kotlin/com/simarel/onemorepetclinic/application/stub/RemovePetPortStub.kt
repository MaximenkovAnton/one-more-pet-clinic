package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.pet.RemovePetPort
import com.simarel.onemorepetclinic.port.output.pet.RemovePetRequest
import com.simarel.onemorepetclinic.port.output.pet.RemovePetResponse

class RemovePetPortStub : RemovePetPort {
    private val removedPetIds = mutableListOf<PetId>()
    private var lastRemovedPetId: PetId? = null

    override fun invoke(request: RemovePetRequest): RemovePetResponse {
        val petId = request.id
        removedPetIds.add(petId)
        lastRemovedPetId = petId
        return RemovePetResponse()
    }

    fun getLastRemovedPetId(): PetId? = lastRemovedPetId

    fun getRemovedPetIds(): List<PetId> = removedPetIds.toList()

    fun wasPetRemoved(id: PetId): Boolean = removedPetIds.contains(id)
}
