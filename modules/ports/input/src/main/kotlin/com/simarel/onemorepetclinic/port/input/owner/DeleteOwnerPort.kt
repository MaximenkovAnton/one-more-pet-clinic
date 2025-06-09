package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface DeleteOwnerPort : InputPort<DeleteOwnerRequest, DeleteOwnerResponse>

class DeleteOwnerRequest(
    val id: OwnerId
) : InInputParam

class DeleteOwnerResponse : OutInputParam
