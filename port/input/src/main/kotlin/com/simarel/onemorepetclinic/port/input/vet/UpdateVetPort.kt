package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface UpdateVetPort : InputPort<UpdateVetRequest, UpdateVetResponse>

class UpdateVetRequest(
    val vet: Vet
)

class UpdateVetResponse(
    val vet: Vet
)
