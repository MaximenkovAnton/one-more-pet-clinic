package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ReadVetPort : InputPort<ReadVetRequest, ReadVetResponse>

class ReadVetRequest(
    val id: VetId
) : InInputParam

class ReadVetResponse(
    val vet: Vet
) : OutInputParam
