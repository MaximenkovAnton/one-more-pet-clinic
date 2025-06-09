package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface UpdateVisitPort : InputPort<UpdateVisitRequest, UpdateVisitResponse>

class UpdateVisitRequest(
    val visit: Visit
) : InInputParam

class UpdateVisitResponse(
    val visit: Visit
) : OutInputParam
