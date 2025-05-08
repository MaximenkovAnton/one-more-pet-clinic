package com.simarel.onemorepetclinic.port.output.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.util.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchAllOwnersPort : OutputPort<FetchAllOwnersRequest, FetchAllOwnersResponse>

class FetchAllOwnersRequest(
    val paginationInfo: PaginationInfo
)

class FetchAllOwnersResponse(
    val owners: List<Owner>,
    val count: Count
)
