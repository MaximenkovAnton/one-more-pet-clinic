package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface CreateVisitPort : InputPort<CreateVisitRequest, CreateVisitResponse>

class CreateVisitRequest(
    val visit: Visit
) : InInputParam

class CreateVisitResponse(
    val visit: Visit
) : OutInputParam
