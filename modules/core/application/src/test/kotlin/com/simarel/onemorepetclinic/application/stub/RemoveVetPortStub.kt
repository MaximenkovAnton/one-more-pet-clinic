package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetPort
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetRequest
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetResponse

class RemoveVetPortStub : RemoveVetPort {
    private val removedVetIds = mutableListOf<VetId>()
    private var lastRemovedVetId: VetId? = null

    override fun invoke(request: RemoveVetRequest): RemoveVetResponse {
        val vetId = request.id
        removedVetIds.add(vetId)
        lastRemovedVetId = vetId
        return RemoveVetResponse()
    }

    fun getLastRemovedVetId(): VetId? = lastRemovedVetId

    fun getRemovedVetIds(): List<VetId> = removedVetIds.toList()

    fun wasVetRemoved(id: VetId): Boolean = removedVetIds.contains(id)
}
