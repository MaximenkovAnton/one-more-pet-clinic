package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName

abstract class Person(
    open val id: Id,
    open val firstName: FirstName,
    open val lastName: LastName,
    open val middleName: MiddleName
)
