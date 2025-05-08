package com.simarel.onemorepetclinic.application.usecase.pet.read

import com.simarel.onemorepetclinic.domain.exception.PetNotFoundException
import com.simarel.onemorepetclinic.port.input.pet.ReadPetPort
import com.simarel.onemorepetclinic.port.input.pet.ReadPetRequest
import com.simarel.onemorepetclinic.port.input.pet.ReadPetResponse
import com.simarel.onemorepetclinic.port.output.pet.FetchPetPort
import com.simarel.onemorepetclinic.port.output.pet.FetchPetRequest

class ReadPetUseCase(private val fetchPetPort: FetchPetPort) : ReadPetPort {
    override fun invoke(request: ReadPetRequest): ReadPetResponse {
        val fetchPetResponse = fetchPetPort.invoke(FetchPetRequest(request.id))
        return fetchPetResponse.pet?.let {
            ReadPetResponse(it)
        } ?: throw PetNotFoundException()
    }
}
