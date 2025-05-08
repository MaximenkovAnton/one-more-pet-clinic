package com.simarel.onemorepetclinic.application.usecase.vet.update

import com.simarel.onemorepetclinic.port.input.vet.UpdateVetPort
import com.simarel.onemorepetclinic.port.input.vet.UpdateVetRequest
import com.simarel.onemorepetclinic.port.input.vet.UpdateVetResponse
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetRequest

class UpdateVetUseCase(private val saveVetPort: SaveVetPort) : UpdateVetPort {
    override fun invoke(request: UpdateVetRequest): UpdateVetResponse {
        val saveVetResponse = saveVetPort.invoke(SaveVetRequest(request.vet))
        return UpdateVetResponse(saveVetResponse.vet)
    }
}
