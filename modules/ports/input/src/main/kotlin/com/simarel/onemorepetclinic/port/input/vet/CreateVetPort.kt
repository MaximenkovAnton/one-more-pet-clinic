package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface CreateVetPort : InputPort<CreateVetRequest, CreateVetResponse>

class CreateVetRequest(
    val vet: Vet
)

class CreateVetResponse(
    val vet: Vet
)
