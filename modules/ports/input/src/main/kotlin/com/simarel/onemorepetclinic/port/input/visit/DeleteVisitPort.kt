package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeleteVisitPort : InputPort<DeleteVisitRequest, DeleteVisitResponse>

class DeleteVisitRequest(
    val id: VisitId
)

class DeleteVisitResponse
