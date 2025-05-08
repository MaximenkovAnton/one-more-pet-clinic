package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface CreateVisitPort : InputPort<CreateVisitRequest, CreateVisitResponse>

class CreateVisitRequest(
    val visit: Visit
)

class CreateVisitResponse(
    val visit: Visit
)
