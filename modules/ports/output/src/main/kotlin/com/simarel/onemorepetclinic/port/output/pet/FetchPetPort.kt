package com.simarel.onemorepetclinic.port.output.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchPetPort : OutputPort<FetchPetRequest, FetchPetResponse>

class FetchPetRequest(
    val id: PetId
)

class FetchPetResponse(
    val pet: Pet?
)
