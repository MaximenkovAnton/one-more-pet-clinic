package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface UpdatePetPort : InputPort<UpdatePetRequest, UpdatePetResponse>

class UpdatePetRequest(
    val pet: Pet
)

class UpdatePetResponse(
    val pet: Pet
)
