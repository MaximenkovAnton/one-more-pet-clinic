package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.Birthday
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.PetName
import com.simarel.onemorepetclinic.domain.valueobject.PetType

class Pet(
    val id: Id,
    val name: PetName,
    val birthday: Birthday,
    val type: PetType,
    val owner: Owner
)
