package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface UpdateVisitPort : InputPort<UpdateVisitRequest, UpdateVisitResponse>

class UpdateVisitRequest(
    val visit: Visit
)

class UpdateVisitResponse(
    val visit: Visit
)
