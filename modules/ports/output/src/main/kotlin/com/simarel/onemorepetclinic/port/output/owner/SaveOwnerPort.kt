package com.simarel.onemorepetclinic.port.output.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface SaveOwnerPort : OutputPort<SaveOwnerRequest, SaveOwnerResponse>

class SaveOwnerRequest(
    val owner: Owner
)

class SaveOwnerResponse(
    val owner: Owner
)
