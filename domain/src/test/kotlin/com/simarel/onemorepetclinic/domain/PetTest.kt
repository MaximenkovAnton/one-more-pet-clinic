package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.domain.factory.ValueObjectFactory
import com.simarel.onemorepetclinic.domain.valueobject.PetType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class PetTest {

    @Test
    fun `should create Pet with valid values`() {
        // Arrange
        val id = ValueObjectFactory.createId()
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
