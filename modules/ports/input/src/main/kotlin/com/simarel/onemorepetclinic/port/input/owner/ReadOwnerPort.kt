package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ReadOwnerPort : InputPort<ReadOwnerRequest, ReadOwnerResponse>

class ReadOwnerRequest(
    val id: OwnerId
) : InInputParam

class ReadOwnerResponse(
    val owner: Owner
) : OutInputParam
