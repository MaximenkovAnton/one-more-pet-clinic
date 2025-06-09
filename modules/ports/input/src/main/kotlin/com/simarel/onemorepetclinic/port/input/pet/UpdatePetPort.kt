package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface UpdatePetPort : InputPort<UpdatePetRequest, UpdatePetResponse>

class UpdatePetRequest(
    val pet: Pet
) : InInputParam

class UpdatePetResponse(
    val pet: Pet
) : OutInputParam
