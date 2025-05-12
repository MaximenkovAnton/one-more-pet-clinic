package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ReadVisitPort : InputPort<ReadVisitRequest, ReadVisitResponse>

class ReadVisitRequest(
    val id: VisitId
)

class ReadVisitResponse(
    val visit: Visit
)
