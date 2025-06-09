package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface UpdateOwnerPort : InputPort<UpdateOwnerRequest, UpdateOwnerResponse>

class UpdateOwnerRequest(
    val owner: Owner
) : InInputParam

class UpdateOwnerResponse(
    val owner: Owner
) : OutInputParam
