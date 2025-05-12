package com.simarel.onemorepetclinic.application.usecase.vet.create

import com.simarel.onemorepetclinic.port.input.vet.CreateVetPort
import com.simarel.onemorepetclinic.port.input.vet.CreateVetRequest
import com.simarel.onemorepetclinic.port.input.vet.CreateVetResponse
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetRequest

class CreateVetUseCase(private val saveVetPort: SaveVetPort) : CreateVetPort {
    override fun invoke(request: CreateVetRequest): CreateVetResponse {
        val saveVetResponse = saveVetPort.invoke(SaveVetRequest(request.vet))
        return CreateVetResponse(saveVetResponse.vet)
    }
}
