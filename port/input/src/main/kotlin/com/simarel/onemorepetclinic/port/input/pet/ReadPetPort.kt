package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ReadPetPort : InputPort<ReadPetRequest, ReadPetResponse>

class ReadPetRequest(
    val id: Id
)

class ReadPetResponse(
    val pet: Pet
)
