package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeleteVetPort : InputPort<DeleteVetRequest, DeleteVetResponse>

class DeleteVetRequest(
    val id: Id
)

class DeleteVetResponse
