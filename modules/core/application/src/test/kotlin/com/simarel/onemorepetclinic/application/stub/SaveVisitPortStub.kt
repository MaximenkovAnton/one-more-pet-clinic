package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitResponse

class SaveVisitPortStub : SaveVisitPort {
    private val visits = mutableMapOf<VisitId, Visit>()
    private var lastSavedVisit: Visit? = null

    override fun invoke(request: SaveVisitRequest): SaveVisitResponse {
        val visit = request.visit
        visits[visit.id] = visit
        lastSavedVisit = visit
        return SaveVisitResponse(visit)
    }

    fun getLastSavedVisit(): Visit? = lastSavedVisit

    fun getVisits(): Map<VisitId, Visit> = visits.toMap()

    fun getVisitById(id: VisitId): Visit? = visits[id]
}
