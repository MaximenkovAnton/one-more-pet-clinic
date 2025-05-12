package com.simarel.onemorepetclinic.port.output.vet

import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface RemoveVetPort : OutputPort<RemoveVetRequest, RemoveVetResponse>

class RemoveVetRequest(
    val id: VetId
)

class RemoveVetResponse
