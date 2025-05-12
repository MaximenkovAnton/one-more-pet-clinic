package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.valueobject.PetType
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class PetTest {

    @Test
    fun `should create Pet with valid values`() {
        // Arrange
        val id = IdFactory.createPetId()
        val name = ValueObjectFactory.createPetName()
        val birthday = ValueObjectFactory.createBirthday()
        val type = ValueObjectFactory.createPetType()
        val owner = DomainObjectFactory.createOwner()

        // Act
        val pet = DomainObjectFactory.createPet(
            id = id,
            name = name,
            birthday = birthday,
            type = type,
            owner = owner
        )

        // Assert
        assertEquals(id, pet.id)
        assertEquals(name, pet.name)
        assertEquals(birthday, pet.birthday)
        assertEquals(type, pet.type)
        assertEquals(owner, pet.owner)
    }

    @ParameterizedTest
    @EnumSource(PetType::class)
    fun `should create Pet with different types`(petType: PetType) {
        // Arrange & Act
        val pet = DomainObjectFactory.createPet(
            type = petType
        )

        // Assert
        assertEquals(petType, pet.type)
    }
}
