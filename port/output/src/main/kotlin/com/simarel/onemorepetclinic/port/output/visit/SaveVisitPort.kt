package com.simarel.onemorepetclinic.port.output.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface SaveVisitPort : OutputPort<SaveVisitRequest, SaveVisitResponse>

class SaveVisitRequest(
    val visit: Visit
)

class SaveVisitResponse(
    val visit: Visit
)
