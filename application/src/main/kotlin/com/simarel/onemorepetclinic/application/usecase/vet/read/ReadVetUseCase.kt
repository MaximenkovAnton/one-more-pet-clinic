package com.simarel.onemorepetclinic.application.usecase.vet.read

import com.simarel.onemorepetclinic.domain.exception.VetNotFoundException
import com.simarel.onemorepetclinic.port.input.vet.ReadVetPort
import com.simarel.onemorepetclinic.port.input.vet.ReadVetRequest
import com.simarel.onemorepetclinic.port.input.vet.ReadVetResponse
import com.simarel.onemorepetclinic.port.output.vet.FetchVetPort
import com.simarel.onemorepetclinic.port.output.vet.FetchVetRequest

class ReadVetUseCase(private val fetchVetPort: FetchVetPort) : ReadVetPort {
    override fun invoke(request: ReadVetRequest): ReadVetResponse {
        val fetchVetResponse = fetchVetPort.invoke(FetchVetRequest(request.id))
        return fetchVetResponse.vet?.let {
            ReadVetResponse(it)
        } ?: throw VetNotFoundException()
    }
}
