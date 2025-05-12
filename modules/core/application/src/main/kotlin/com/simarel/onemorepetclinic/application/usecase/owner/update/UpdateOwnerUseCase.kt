package com.simarel.onemorepetclinic.application.usecase.owner.update

import com.simarel.onemorepetclinic.port.input.owner.UpdateOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.UpdateOwnerRequest
import com.simarel.onemorepetclinic.port.input.owner.UpdateOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerRequest

class UpdateOwnerUseCase(private val saveOwnerPort: SaveOwnerPort) : UpdateOwnerPort {
    override fun invoke(request: UpdateOwnerRequest): UpdateOwnerResponse {
        val saveOwnerResponse = saveOwnerPort.invoke(SaveOwnerRequest(request.owner))
        return UpdateOwnerResponse(saveOwnerResponse.owner)
    }
}
