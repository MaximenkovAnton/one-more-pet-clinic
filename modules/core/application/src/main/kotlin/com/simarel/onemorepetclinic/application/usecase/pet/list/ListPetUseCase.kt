package com.simarel.onemorepetclinic.application.usecase.pet.list

import com.simarel.onemorepetclinic.port.input.pet.ListPetPort
import com.simarel.onemorepetclinic.port.input.pet.ListPetRequest
import com.simarel.onemorepetclinic.port.input.pet.ListPetResponse
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsPort
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsRequest

class ListPetUseCase(private val fetchAllPetsPort: FetchAllPetsPort) : ListPetPort {
    override fun invoke(request: ListPetRequest): ListPetResponse {
        val fetchAllPetsResponse = fetchAllPetsPort.invoke(
            FetchAllPetsRequest(
                paginationInfo = request.paginationInfo,
                ownerId = request.ownerId
            )
        )
        return ListPetResponse(
            pets = fetchAllPetsResponse.pets,
            count = fetchAllPetsResponse.count
        )
    }
}
