package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface CreatePetPort : InputPort<CreatePetRequest, CreatePetResponse>

class CreatePetRequest(
    val pet: Pet
)

class CreatePetResponse(
    val pet: Pet
)
