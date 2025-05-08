package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.Speciality

data class Vet(
    override val id: Id,
    override val firstName: FirstName,
    override val lastName: LastName,
    override val middleName: MiddleName,
    val specialities: Set<Speciality>
) : Person(id, firstName, lastName, middleName)
