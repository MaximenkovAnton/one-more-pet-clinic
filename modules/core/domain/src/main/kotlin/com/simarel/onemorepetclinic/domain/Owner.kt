package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.Address
import com.simarel.onemorepetclinic.domain.valueobject.City
import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.Phone
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId

data class Owner(
    override val id: OwnerId,
    override val firstName: FirstName,
    override val lastName: LastName,
    override val middleName: MiddleName,
    val address: Address,
    val city: City,
    val phone: Phone,
    val pets: Set<Pet>
) : Person<OwnerId>(id, firstName, lastName, middleName)
