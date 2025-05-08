package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.Description
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.VisitDate

class Visit(
    val id: Id,
    val date: VisitDate,
    val description: Description,
    val pet: Pet
)
