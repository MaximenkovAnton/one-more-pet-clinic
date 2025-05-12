package com.simarel.onemorepetclinic.application.usecase.visit.create

import com.simarel.onemorepetclinic.port.input.visit.CreateVisitPort
import com.simarel.onemorepetclinic.port.input.visit.CreateVisitRequest
import com.simarel.onemorepetclinic.port.input.visit.CreateVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitRequest

class CreateVisitUseCase(private val saveVisitPort: SaveVisitPort) : CreateVisitPort {
    override fun invoke(request: CreateVisitRequest): CreateVisitResponse {
        val saveVisitResponse = saveVisitPort.invoke(SaveVisitRequest(request.visit))
        return CreateVisitResponse(saveVisitResponse.visit)
    }
}
