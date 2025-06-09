package com.simarel.onemorepetclinic.port.input.visit

import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface DeleteVisitPort : InputPort<DeleteVisitRequest, DeleteVisitResponse>

class DeleteVisitRequest(
    val id: VisitId
) : InInputParam

class DeleteVisitResponse : OutInputParam
