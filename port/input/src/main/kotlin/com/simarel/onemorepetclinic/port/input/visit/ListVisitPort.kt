package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.util.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.VisitDate
import com.simarel.onemorepetclinic.port.input.InputPort

fun interface ListVisitPort : InputPort<ListVisitRequest, ListVisitResponse>

class ListVisitRequest(
    val paginationInfo: PaginationInfo,
    val petId: Id?,
)

class ListVisitResponse(
    val visits: List<Visit>,
    val count: Count
)
