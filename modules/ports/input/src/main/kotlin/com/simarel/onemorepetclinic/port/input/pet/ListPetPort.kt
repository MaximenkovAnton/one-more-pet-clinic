package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ListPetPort : InputPort<ListPetRequest, ListPetResponse>

class ListPetRequest(
    val paginationInfo: PaginationInfo,
    val ownerId: Id?
)

class ListPetResponse(
    val pets: List<Pet>,
    val count: Count
)
