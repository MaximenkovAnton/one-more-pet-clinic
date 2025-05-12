package com.simarel.onemorepetclinic.port.output.pet

import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface RemovePetPort : OutputPort<RemovePetRequest, RemovePetResponse>

class RemovePetRequest(
    val id: PetId
)

class RemovePetResponse
