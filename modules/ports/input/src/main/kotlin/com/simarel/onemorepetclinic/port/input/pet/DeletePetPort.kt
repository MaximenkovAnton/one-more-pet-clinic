package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeletePetPort : InputPort<DeletePetRequest, DeletePetResponse>

class DeletePetRequest(
    val id: PetId
)

class DeletePetResponse
