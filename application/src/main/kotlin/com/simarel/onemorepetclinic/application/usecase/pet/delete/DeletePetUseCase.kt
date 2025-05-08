package com.simarel.onemorepetclinic.application.usecase.pet.delete

import com.simarel.onemorepetclinic.port.input.pet.DeletePetPort
import com.simarel.onemorepetclinic.port.input.pet.DeletePetRequest
import com.simarel.onemorepetclinic.port.input.pet.DeletePetResponse
import com.simarel.onemorepetclinic.port.output.pet.RemovePetPort
import com.simarel.onemorepetclinic.port.output.pet.RemovePetRequest

class DeletePetUseCase(private val removePetPort: RemovePetPort) : DeletePetPort {
    override fun invoke(request: DeletePetRequest): DeletePetResponse {
        val removePetResponse = removePetPort.invoke(RemovePetRequest(request.id))
        return DeletePetResponse()
    }
}
