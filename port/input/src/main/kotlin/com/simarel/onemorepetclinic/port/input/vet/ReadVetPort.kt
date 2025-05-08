package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ReadVetPort : InputPort<ReadVetRequest, ReadVetResponse>

class ReadVetRequest(
    val id: Id
)

class ReadVetResponse(
    val vet: Vet
)
