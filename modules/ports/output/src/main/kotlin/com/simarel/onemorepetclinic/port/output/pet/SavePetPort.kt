package com.simarel.onemorepetclinic.port.output.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface SavePetPort : OutputPort<SavePetRequest, SavePetResponse>

class SavePetRequest(
    val pet: Pet
)

class SavePetResponse(
    val pet: Pet
)
