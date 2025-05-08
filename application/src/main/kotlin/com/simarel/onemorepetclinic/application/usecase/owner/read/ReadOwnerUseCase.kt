package com.simarel.onemorepetclinic.application.usecase.owner.read

import com.simarel.onemorepetclinic.domain.exception.OwnerNotFoundException
import com.simarel.onemorepetclinic.port.input.owner.ReadOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.ReadOwnerRequest
import com.simarel.onemorepetclinic.port.input.owner.ReadOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerRequest

class ReadOwnerUseCase(private val fetchOwnerPort: FetchOwnerPort) : ReadOwnerPort {
    override fun invoke(request: ReadOwnerRequest): ReadOwnerResponse {
        val fetchOwnerResponse = fetchOwnerPort.invoke(FetchOwnerRequest(request.id))
        return fetchOwnerResponse.owner?.let {
            ReadOwnerResponse(it)
        } ?: throw OwnerNotFoundException()
    }
}
