package com.simarel.onemorepetclinic.application.usecase.vet.list

import com.simarel.onemorepetclinic.port.input.vet.ListVetPort
import com.simarel.onemorepetclinic.port.input.vet.ListVetRequest
import com.simarel.onemorepetclinic.port.input.vet.ListVetResponse
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsPort
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsRequest

class ListVetUseCase(private val fetchAllVetsPort: FetchAllVetsPort) : ListVetPort {
    override fun invoke(request: ListVetRequest): ListVetResponse {
        val fetchAllVetsResponse = fetchAllVetsPort.invoke(
            FetchAllVetsRequest(
                paginationInfo = request.paginationInfo,
                speciality = request.speciality
            )
        )
        return ListVetResponse(
            vets = fetchAllVetsResponse.vets,
            count = fetchAllVetsResponse.count
        )
    }
}
