package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitResponse

class RemoveVisitPortStub : RemoveVisitPort {
    private val removedVisitIds = mutableListOf<VisitId>()
    private var lastRemovedVisitId: VisitId? = null

    override fun invoke(request: RemoveVisitRequest): RemoveVisitResponse {
        val visitId = request.id
        removedVisitIds.add(visitId)
        lastRemovedVisitId = visitId
        return RemoveVisitResponse()
    }

    fun getLastRemovedVisitId(): VisitId? = lastRemovedVisitId

    fun getRemovedVisitIds(): List<VisitId> = removedVisitIds.toList()

    fun wasVisitRemoved(id: VisitId): Boolean = removedVisitIds.contains(id)
}
