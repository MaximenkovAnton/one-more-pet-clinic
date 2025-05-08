package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VetTest {

    @Test
    fun `should create Vet with valid values`() {
        // Arrange
        val id = ValueObjectFactory.createId()
        val firstName = ValueObjectFactory.createFirstName("Петр")
        val lastName = ValueObjectFactory.createLastName("Петров")
        val middleName = ValueObjectFactory.createMiddleName("Петрович")

        // Act
        val vet = DomainObjectFactory.createVet(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            specialities = emptySet()
        )

        // Assert
        assertEquals(id, vet.id)
        assertEquals(firstName, vet.firstName)
        assertEquals(lastName, vet.lastName)
        assertEquals(middleName, vet.middleName)
        assertTrue(vet.specialities.isEmpty())
    }

    @Test
    fun `should create Vet with specialities`() {
        // Arrange
        val speciality1 = ValueObjectFactory.createSpeciality("Хирургия")
        val speciality2 = ValueObjectFactory.createSpeciality("Терапия")
        val specialities = setOf(speciality1, speciality2)

        // Act
        val vet = DomainObjectFactory.createVet(
            specialities = specialities
        )

        // Assert
        assertEquals(2, vet.specialities.size)
        assertTrue(vet.specialities.contains(speciality1))
        assertTrue(vet.specialities.contains(speciality2))
    }

    @Test
    fun `should be equal when all properties are equal`() {
        // Arrange
        val id = ValueObjectFactory.createId()
        val firstName = ValueObjectFactory.createFirstName("Петр")
        val lastName = ValueObjectFactory.createLastName("Петров")
        val middleName = ValueObjectFactory.createMiddleName("Петрович")
        val speciality = ValueObjectFactory.createSpeciality()
        val specialities = setOf(speciality)

        // Act
        val vet1 = DomainObjectFactory.createVet(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            specialities = specialities
        )

        val vet2 = DomainObjectFactory.createVet(
            id = id,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            specialities = specialities
        )

        // Assert
        assertEquals(vet1, vet2)
        assertEquals(vet1.hashCode(), vet2.hashCode())
    }
}
