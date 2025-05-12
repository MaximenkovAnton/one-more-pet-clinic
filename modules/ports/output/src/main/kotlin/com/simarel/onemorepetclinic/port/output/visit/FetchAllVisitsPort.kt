package com.simarel.onemorepetclinic.port.output.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchAllVisitsPort : OutputPort<FetchAllVisitsRequest, FetchAllVisitsResponse>

class FetchAllVisitsRequest(
    val paginationInfo: PaginationInfo,
    val petId: Id?,
)

class FetchAllVisitsResponse(
    val visits: List<Visit>,
    val count: Count
)
