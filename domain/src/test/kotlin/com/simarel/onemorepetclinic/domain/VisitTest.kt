package com.simarel.onemorepetclinic.domain

import com.simarel.onemorepetclinic.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class VisitTest {

    @Test
    fun `should create Visit with valid values`() {
        // Arrange
        val id = ValueObjectFactory.createId()
        val date = ValueObjectFactory.createVisitDate()
        val description = ValueObjectFactory.createDescription()
        val pet = DomainObjectFactory.createPet()

        // Act
        val visit = DomainObjectFactory.createVisit(
            id = id,
            date = date,
            description = description,
            pet = pet
        )

        // Assert
        assertEquals(id, visit.id)
        assertEquals(date, visit.date)
        assertEquals(description, visit.description)
        assertEquals(pet, visit.pet)
    }

    @Test
    fun `should create Visit with future date`() {
        // Arrange
        val futureDate = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(30))

        // Act
        val visit = DomainObjectFactory.createVisit(
            date = futureDate
        )

        // Assert
        assertEquals(futureDate, visit.date)
    }
}
