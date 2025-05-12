package com.simarel.onemorepetclinic.port.output.visit

import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface RemoveVisitPort : OutputPort<RemoveVisitRequest, RemoveVisitResponse>

class RemoveVisitRequest(
    val id: VisitId
)

class RemoveVisitResponse
