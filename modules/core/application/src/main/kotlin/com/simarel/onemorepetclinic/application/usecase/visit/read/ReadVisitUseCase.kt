package com.simarel.onemorepetclinic.application.usecase.visit.read

import com.simarel.onemorepetclinic.domain.exception.VisitNotFoundException
import com.simarel.onemorepetclinic.port.input.visit.ReadVisitPort
import com.simarel.onemorepetclinic.port.input.visit.ReadVisitRequest
import com.simarel.onemorepetclinic.port.input.visit.ReadVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitPort
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitRequest

class ReadVisitUseCase(private val fetchVisitPort: FetchVisitPort) : ReadVisitPort {
    override fun invoke(request: ReadVisitRequest): ReadVisitResponse {
        val fetchVisitResponse = fetchVisitPort.invoke(FetchVisitRequest(request.id))
        return fetchVisitResponse.visit?.let {
            ReadVisitResponse(it)
        } ?: throw VisitNotFoundException()
    }
}
