package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface UpdateVetPort : InputPort<UpdateVetRequest, UpdateVetResponse>

class UpdateVetRequest(
    val vet: Vet
) : InInputParam

class UpdateVetResponse(
    val vet: Vet
) : OutInputParam
