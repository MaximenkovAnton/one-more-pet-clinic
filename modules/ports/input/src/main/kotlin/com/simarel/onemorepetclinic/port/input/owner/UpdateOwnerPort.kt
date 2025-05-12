package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface UpdateOwnerPort : InputPort<UpdateOwnerRequest, UpdateOwnerResponse>

class UpdateOwnerRequest(
    val owner: Owner
)

class UpdateOwnerResponse(
    val owner: Owner
)
