package com.simarel.onemorepetclinic.port.output.owner

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.OutputPort

fun interface FetchOwnerPort : OutputPort<FetchOwnerRequest, FetchOwnerResponse>

class FetchOwnerRequest(
    val id: OwnerId
)

class FetchOwnerResponse(
    val owner: Owner?
)
