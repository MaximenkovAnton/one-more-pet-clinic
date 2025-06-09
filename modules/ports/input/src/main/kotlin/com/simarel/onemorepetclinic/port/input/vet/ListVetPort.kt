package com.simarel.onemorepetclinic.port.input.vet

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.InInputParam
import com.simarel.onemorepetclinic.port.input.InputPort
import com.simarel.onemorepetclinic.port.input.OutInputParam

fun interface ListVetPort : InputPort<ListVetRequest, ListVetResponse>

class ListVetRequest(
    val paginationInfo: PaginationInfo,
    val speciality: Speciality?
) : InInputParam

class ListVetResponse(
    val vets: List<Vet>,
    val count: Count
) : OutInputParam
