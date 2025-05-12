package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.id.EntityId

abstract class Person<T : EntityId>(
    open val id: T,
    open val firstName: FirstName,
    open val lastName: LastName,
    open val middleName: MiddleName
)
