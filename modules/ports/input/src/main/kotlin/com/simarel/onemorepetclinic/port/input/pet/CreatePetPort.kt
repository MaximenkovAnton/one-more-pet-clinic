package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface CreatePetPort : InputPort<CreatePetRequest, CreatePetResponse>

class CreatePetRequest(
    val pet: Pet
) : InInputParam

class CreatePetResponse(
    val pet: Pet
) : OutInputParam
