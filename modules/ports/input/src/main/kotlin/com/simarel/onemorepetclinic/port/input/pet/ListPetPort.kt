package com.simarel.onemorepetclinic.port.input.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ListPetPort : InputPort<ListPetRequest, ListPetResponse>

class ListPetRequest(
    val paginationInfo: PaginationInfo,
    val ownerId: OwnerId?
) : InInputParam

class ListPetResponse(
    val pets: List<Pet>,
    val count: Count
) : OutInputParam
