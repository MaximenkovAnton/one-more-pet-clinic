package com.simarel.onemorepetclinic.port.output.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchVetPort : OutputPort<FetchVetRequest, FetchVetResponse>

class FetchVetRequest(
    val id: Id
)

class FetchVetResponse(
    val vet: Vet?
)
