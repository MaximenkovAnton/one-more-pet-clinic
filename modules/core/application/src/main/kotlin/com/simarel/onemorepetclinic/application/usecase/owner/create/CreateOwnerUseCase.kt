package com.simarel.onemorepetclinic.application.usecase.owner.create

import com.simarel.onemorepetclinic.port.input.owner.CreateOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.CreateOwnerRequest
import com.simarel.onemorepetclinic.port.input.owner.CreateOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerRequest

class CreateOwnerUseCase(private val saveOwnerPort: SaveOwnerPort) : CreateOwnerPort {
    override fun invoke(request: CreateOwnerRequest): CreateOwnerResponse {
        val saveOwnerResponse = saveOwnerPort.invoke(SaveOwnerRequest(request.owner))
        return CreateOwnerResponse(saveOwnerResponse.owner)
    }
}
