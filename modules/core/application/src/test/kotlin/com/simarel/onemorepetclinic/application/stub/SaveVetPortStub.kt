package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetRequest
import com.simarel.onemorepetclinic.port.output.vet.SaveVetResponse

class SaveVetPortStub : SaveVetPort {
    private val vets = mutableMapOf<VetId, Vet>()
    private var lastSavedVet: Vet? = null

    override fun invoke(request: SaveVetRequest): SaveVetResponse {
        val vet = request.vet
        vets[vet.id] = vet
        lastSavedVet = vet
        return SaveVetResponse(vet)
    }

    fun getLastSavedVet(): Vet? = lastSavedVet

    fun getVets(): Map<VetId, Vet> = vets.toMap()

    fun getVetById(id: VetId): Vet? = vets[id]
}
