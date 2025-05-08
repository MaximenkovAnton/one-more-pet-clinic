package com.simarel.onemorepetclinic.application.usecase.pet.create

import com.simarel.onemorepetclinic.port.input.pet.CreatePetPort
import com.simarel.onemorepetclinic.port.input.pet.CreatePetRequest
import com.simarel.onemorepetclinic.port.input.pet.CreatePetResponse
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetRequest

class CreatePetUseCase(private val savePetPort: SavePetPort) : CreatePetPort {
    override fun invoke(request: CreatePetRequest): CreatePetResponse {
        val savePetResponse = savePetPort.invoke(SavePetRequest(request.pet))
        return CreatePetResponse(savePetResponse.pet)
    }
}
