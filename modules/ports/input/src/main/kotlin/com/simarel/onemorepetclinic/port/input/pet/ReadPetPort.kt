package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ReadPetPort : InputPort<ReadPetRequest, ReadPetResponse>

class ReadPetRequest(
    val id: PetId
) : InInputParam

class ReadPetResponse(
    val pet: Pet
) : OutInputParam
