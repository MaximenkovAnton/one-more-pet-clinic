package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface CreateVetPort : InputPort<CreateVetRequest, CreateVetResponse>

class CreateVetRequest(
    val vet: Vet
) : InInputParam

class CreateVetResponse(
    val vet: Vet
) : OutInputParam
