package com.simarel.onemorepetclinic.port.output.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchVisitPort : OutputPort<FetchVisitRequest, FetchVisitResponse>

class FetchVisitRequest(
    val id: VisitId
)

class FetchVisitResponse(
    val visit: Visit?
)
