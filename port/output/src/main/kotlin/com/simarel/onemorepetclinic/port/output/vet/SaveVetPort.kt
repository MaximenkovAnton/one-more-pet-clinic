package com.simarel.onemorepetclinic.port.output.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface SaveVetPort : OutputPort<SaveVetRequest, SaveVetResponse>

class SaveVetRequest(
    val vet: Vet
)

class SaveVetResponse(
    val vet: Vet
)
