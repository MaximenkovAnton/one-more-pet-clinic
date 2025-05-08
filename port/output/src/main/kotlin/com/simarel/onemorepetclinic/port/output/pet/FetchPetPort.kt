package com.simarel.onemorepetclinic.port.output.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchPetPort : OutputPort<FetchPetRequest, FetchPetResponse>

class FetchPetRequest(
    val id: Id
)

class FetchPetResponse(
    val pet: Pet?
)
