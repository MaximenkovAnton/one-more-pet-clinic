package com.simarel.onemorepetclinic.application.usecase.visit.list

import com.simarel.onemorepetclinic.port.input.visit.ListVisitPort
import com.simarel.onemorepetclinic.port.input.visit.ListVisitRequest
import com.simarel.onemorepetclinic.port.input.visit.ListVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsPort
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsRequest

class ListVisitUseCase(private val fetchAllVisitsPort: FetchAllVisitsPort) : ListVisitPort {
    override fun invoke(request: ListVisitRequest): ListVisitResponse {
        val fetchAllVisitsResponse = fetchAllVisitsPort.invoke(
            FetchAllVisitsRequest(
                paginationInfo = request.paginationInfo,
                petId = request.petId
            )
        )
        return ListVisitResponse(
            visits = fetchAllVisitsResponse.visits,
            count = fetchAllVisitsResponse.count
        )
    }
}
