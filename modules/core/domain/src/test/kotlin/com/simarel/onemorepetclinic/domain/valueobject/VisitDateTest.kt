package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class VisitDateTest {

    @Test
    fun `should create VisitDate when date is valid`() {
        // Arrange
        val date = LocalDate.now()

        // Act
        val visitDate = VisitDate.of(date)

        // Assert
        assertEquals(date, visitDate.value)
    }

    @Test
    fun `should create VisitDate from valid date string`() {
        // Arrange
        val dateString = "2023-05-15"
        val expectedDate = LocalDate.of(2023, 5, 15)

        // Act
        val visitDate = VisitDate.fromString(dateString)

        // Assert
        assertEquals(expectedDate, visitDate.value)
    }

    @Test
    fun `should throw VisitDateInvalidFormatValidationException when date string is invalid`() {
        // Arrange
        val invalidDateString = "not-a-date"

        // Act & Assert
        assertThrows<VisitDateInvalidFormatValidationException> { VisitDate.fromString(invalidDateString) }
    }

    @Test
    fun `should format date correctly when toString is called`() {
        // Arrange
        val date = LocalDate.of(2023, 5, 15)
        val visitDate = VisitDate.of(date)
        val expectedString = "2023-05-15"

        // Act
        val result = visitDate.toString()

        // Assert
        assertEquals(expectedString, result)
    }
}
