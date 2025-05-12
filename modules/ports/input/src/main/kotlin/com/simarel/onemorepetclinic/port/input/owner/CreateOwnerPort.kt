package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface CreateOwnerPort : InputPort<CreateOwnerRequest, CreateOwnerResponse>

class CreateOwnerRequest(
    val owner: Owner
)

class CreateOwnerResponse(
    val owner: Owner
)
