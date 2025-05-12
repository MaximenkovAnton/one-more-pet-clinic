package com.simarel.onemorepetclinic.application.usecase.owner.delete

import com.simarel.onemorepetclinic.port.input.owner.DeleteOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.DeleteOwnerRequest
import com.simarel.onemorepetclinic.port.input.owner.DeleteOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerRequest

class DeleteOwnerUseCase(private val removeOwnerPort: RemoveOwnerPort) : DeleteOwnerPort {
    override fun invoke(request: DeleteOwnerRequest): DeleteOwnerResponse {
        val removeOwnerResponse = removeOwnerPort.invoke(RemoveOwnerRequest(request.id))
        return DeleteOwnerResponse()
    }
}
