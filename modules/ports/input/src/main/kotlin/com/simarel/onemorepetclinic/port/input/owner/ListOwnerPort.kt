package com.simarel.onemorepetclinic.port.input.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ListOwnerPort : InputPort<ListOwnerRequest, ListOwnerResponse>

class ListOwnerRequest(
    val paginationInfo: PaginationInfo
) : InInputParam

class ListOwnerResponse(
    val owners: List<Owner>,
    val count: Count
) : OutInputParam
