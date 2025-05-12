package com.simarel.onemorepetclinic.port.output.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchAllVetsPort : OutputPort<FetchAllVetsRequest, FetchAllVetsResponse>

class FetchAllVetsRequest(
    val paginationInfo: PaginationInfo,
    val speciality: Speciality?
)

class FetchAllVetsResponse(
    val vets: List<Vet>,
    val count: Count
)
