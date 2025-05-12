package com.simarel.onemorepetclinic.port.output.vet

import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface RemoveVetPort : OutputPort<RemoveVetRequest, RemoveVetResponse>

class RemoveVetRequest(
    val id: Id
)

class RemoveVetResponse
