package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface DeleteVetPort : InputPort<DeleteVetRequest, DeleteVetResponse>

class DeleteVetRequest(
    val id: VetId
) : InInputParam

class DeleteVetResponse : OutInputParam
