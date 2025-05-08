package com.simarel.onemorepetclinic.port.output.pet

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.util.PaginationInfo
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchAllPetsPort : OutputPort<FetchAllPetsRequest, FetchAllPetsResponse>

class FetchAllPetsRequest(
    val paginationInfo: PaginationInfo,
    val ownerId: Id?
)

class FetchAllPetsResponse(
    val pets: List<Pet>,
    val count: Count
)
