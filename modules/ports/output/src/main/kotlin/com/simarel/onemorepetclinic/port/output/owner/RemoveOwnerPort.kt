package com.simarel.onemorepetclinic.port.output.owner

import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface RemoveOwnerPort : OutputPort<RemoveOwnerRequest, RemoveOwnerResponse>

class RemoveOwnerRequest(
    val id: OwnerId
)

class RemoveOwnerResponse
