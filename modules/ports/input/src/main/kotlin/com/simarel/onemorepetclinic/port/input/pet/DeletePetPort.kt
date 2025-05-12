package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeletePetPort : InputPort<DeletePetRequest, DeletePetResponse>

class DeletePetRequest(
    val id: Id
)

class DeletePetResponse
