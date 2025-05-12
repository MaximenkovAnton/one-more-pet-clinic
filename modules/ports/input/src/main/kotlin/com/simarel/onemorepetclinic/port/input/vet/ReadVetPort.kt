package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ReadVetPort : InputPort<ReadVetRequest, ReadVetResponse>

class ReadVetRequest(
    val id: VetId
)

class ReadVetResponse(
    val vet: Vet
)
