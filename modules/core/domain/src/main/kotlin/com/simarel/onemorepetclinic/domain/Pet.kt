package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.Birthday
import com.simarel.onemorepetclinic.domain.valueobject.PetName
import com.simarel.onemorepetclinic.domain.valueobject.PetType
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId

class Pet(
    val id: PetId,
    val name: PetName,
    val birthday: Birthday,
    val type: PetType,
    val owner: Owner
)
