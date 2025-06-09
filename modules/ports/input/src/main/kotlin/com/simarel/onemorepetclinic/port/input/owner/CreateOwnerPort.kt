package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface CreateOwnerPort : InputPort<CreateOwnerRequest, CreateOwnerResponse>

class CreateOwnerRequest(
    val owner: Owner
) : InInputParam

class CreateOwnerResponse(
    val owner: Owner
) : OutInputParam
