package com.simarel.onemorepetclinic.application.usecase.visit.delete

import com.simarel.onemorepetclinic.port.input.visit.DeleteVisitPort
import com.simarel.onemorepetclinic.port.input.visit.DeleteVisitRequest
import com.simarel.onemorepetclinic.port.input.visit.DeleteVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitRequest

class DeleteVisitUseCase(private val removeVisitPort: RemoveVisitPort) : DeleteVisitPort {
    override fun invoke(request: DeleteVisitRequest): DeleteVisitResponse {
        val removeVisitResponse = removeVisitPort.invoke(RemoveVisitRequest(request.id))
        return DeleteVisitResponse()
    }
}
