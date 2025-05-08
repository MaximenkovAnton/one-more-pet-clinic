package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OwnerTest {

    @Test
    fun `should create Owner with valid values`() {
        // Arrange
        val id = ValueObjectFactory.createId()
        val firstName = ValueObjectFactory.createFirstName()
        val lastName = ValueObjectFactory.createLastName()
        val middleName = ValueObjectFactory.createMiddleName()
        val address = ValueObjectFactory.createAddress()
        val city = ValueObjectFactory.createCity()
        val phone = ValueObjectFactory.createPhone()

        // Act
        val owner = DomainObjectFactory.createOwner(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            address = address,
            city = city,
            phone = phone
        )

        // Assert
        assertEquals(id, owner.id)
        assertEquals(firstName, owner.firstName)
        assertEquals(lastName, owner.lastName)
        assertEquals(middleName, owner.middleName)
        assertEquals(address, owner.address)
        assertEquals(city, owner.city)
        assertEquals(phone, owner.phone)
        assertTrue(owner.pets.isEmpty())
    }

    @Test
    fun `should create Owner with pets`() {
        // Arrange
        val ownerWithoutPets = DomainObjectFactory.createOwner()
        val pet = DomainObjectFactory.createPet(owner = ownerWithoutPets)

        // Act
        val ownerWithPet = DomainObjectFactory.createOwner(
            id = ownerWithoutPets.id,
            firstName = ownerWithoutPets.firstName,
            lastName = ownerWithoutPets.lastName,
            middleName = ownerWithoutPets.middleName,
            address = ownerWithoutPets.address,
            city = ownerWithoutPets.city,
            phone = ownerWithoutPets.phone,
            pets = setOf(pet)
        )

        // Assert
        assertEquals(1, ownerWithPet.pets.size)
        val petFromOwner = ownerWithPet.pets.first()
        assertEquals(pet.id, petFromOwner.id)
        assertEquals(pet.name, petFromOwner.name)
        assertEquals(pet.birthday, petFromOwner.birthday)
        assertEquals(pet.type, petFromOwner.type)
        assertEquals(ownerWithoutPets.id, petFromOwner.owner.id)
    }

    @Test
    fun `should be equal when all properties are equal`() {
        // Arrange
        val id = ValueObjectFactory.createId()
        val firstName = ValueObjectFactory.createFirstName()
        val lastName = ValueObjectFactory.createLastName()
        val middleName = ValueObjectFactory.createMiddleName()
        val address = ValueObjectFactory.createAddress()
        val city = ValueObjectFactory.createCity()
        val phone = ValueObjectFactory.createPhone()

        // Act
        val owner1 = DomainObjectFactory.createOwner(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            address = address,
            city = city,
            phone = phone
        )

        val owner2 = DomainObjectFactory.createOwner(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            address = address,
            city = city,
            phone = phone
        )

        // Assert
        assertEquals(owner1, owner2)
        assertEquals(owner1.hashCode(), owner2.hashCode())
    }
}
