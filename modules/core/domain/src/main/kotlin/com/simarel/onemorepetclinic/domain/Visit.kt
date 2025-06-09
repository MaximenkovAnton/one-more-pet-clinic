package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.Description
import com.simarel.onemorepetclinic.domain.valueobject.VisitDate
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId

class Visit(
    val id: VisitId,
    val date: VisitDate,
    val description: Description,
    val pet: Pet,
    val vet: Vet,
)
