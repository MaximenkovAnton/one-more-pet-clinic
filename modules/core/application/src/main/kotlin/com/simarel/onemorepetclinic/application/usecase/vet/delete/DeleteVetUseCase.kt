package com.simarel.onemorepetclinic.application.usecase.vet.delete

import com.simarel.onemorepetclinic.port.input.vet.DeleteVetPort
import com.simarel.onemorepetclinic.port.input.vet.DeleteVetRequest
import com.simarel.onemorepetclinic.port.input.vet.DeleteVetResponse
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetPort
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetRequest

class DeleteVetUseCase(private val removeVetPort: RemoveVetPort) : DeleteVetPort {
    override fun invoke(request: DeleteVetRequest): DeleteVetResponse {
        val removeVetResponse = removeVetPort.invoke(RemoveVetRequest(request.id))
        return DeleteVetResponse()
    }
}
