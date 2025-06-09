package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface DeletePetPort : InputPort<DeletePetRequest, DeletePetResponse>

class DeletePetRequest(
    val id: PetId
) : InInputParam

class DeletePetResponse : OutInputParam
