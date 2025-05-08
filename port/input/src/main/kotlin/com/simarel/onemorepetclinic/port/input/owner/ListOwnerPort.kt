package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.util.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ListOwnerPort : InputPort<ListOwnerRequest, ListOwnerResponse>

class ListOwnerRequest(
    val paginationInfo: PaginationInfo
)

class ListOwnerResponse(
    val owners: List<Owner>,
    val count: Count
)
