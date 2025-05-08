package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeleteVisitPort : InputPort<DeleteVisitRequest, DeleteVisitResponse>

class DeleteVisitRequest(
    val id: Id
)

class DeleteVisitResponse
