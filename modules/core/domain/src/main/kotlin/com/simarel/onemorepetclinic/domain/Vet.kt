package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId

data class Vet(
    override val id: VetId,
    override val firstName: FirstName,
    override val lastName: LastName,
    override val middleName: MiddleName,
    val specialities: Set<Speciality>
) : Person<VetId>(id, firstName, lastName, middleName)
