package com.simarel.onemorepetclinic.application.usecase.visit.update

import com.simarel.onemorepetclinic.port.input.visit.UpdateVisitPort
import com.simarel.onemorepetclinic.port.input.visit.UpdateVisitRequest
import com.simarel.onemorepetclinic.port.input.visit.UpdateVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitRequest

class UpdateVisitUseCase(private val saveVisitPort: SaveVisitPort) : UpdateVisitPort {
    override fun invoke(request: UpdateVisitRequest): UpdateVisitResponse {
        val saveVisitResponse = saveVisitPort.invoke(SaveVisitRequest(request.visit))
        return UpdateVisitResponse(saveVisitResponse.visit)
    }
}
