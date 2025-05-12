package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeleteOwnerPort : InputPort<DeleteOwnerRequest, DeleteOwnerResponse>

class DeleteOwnerRequest(
    val id: Id
)

class DeleteOwnerResponse
