package com.simarel.onemorepetclinic.application.usecase.owner.list

import com.simarel.onemorepetclinic.port.input.owner.ListOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.ListOwnerRequest
import com.simarel.onemorepetclinic.port.input.owner.ListOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersPort
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersRequest

class ListOwnerUseCase(private val fetchAllOwnersPort: FetchAllOwnersPort) : ListOwnerPort {
    override fun invoke(request: ListOwnerRequest): ListOwnerResponse {
        val fetchAllOwnersResponse = fetchAllOwnersPort.invoke(
            FetchAllOwnersRequest(
                paginationInfo = request.paginationInfo
            )
        )
        return ListOwnerResponse(
            owners = fetchAllOwnersResponse.owners,
            count = fetchAllOwnersResponse.count
        )
    }
}
