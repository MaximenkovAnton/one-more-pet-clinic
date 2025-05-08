package com.simarel.onemorepetclinic.application.usecase.pet.update

import com.simarel.onemorepetclinic.port.input.pet.UpdatePetPort
import com.simarel.onemorepetclinic.port.input.pet.UpdatePetRequest
import com.simarel.onemorepetclinic.port.input.pet.UpdatePetResponse
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetRequest

class UpdatePetUseCase(private val savePetPort: SavePetPort) : UpdatePetPort {
    override fun invoke(request: UpdatePetRequest): UpdatePetResponse {
        val savePetResponse = savePetPort.invoke(SavePetRequest(request.pet))
        return UpdatePetResponse(savePetResponse.pet)
    }
}
