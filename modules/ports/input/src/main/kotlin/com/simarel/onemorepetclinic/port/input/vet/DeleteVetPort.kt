package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface DeleteVetPort : InputPort<DeleteVetRequest, DeleteVetResponse>

class DeleteVetRequest(
    val id: VetId
)

class DeleteVetResponse
