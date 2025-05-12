package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class BirthdayTest {

    @Test
    fun `should create Birthday when date is in the past`() {
        // Arrange
        val pastDate = LocalDate.now().minusDays(1)

        // Act
        val birthday = Birthday.of(pastDate)

        // Assert
        assertEquals(pastDate, birthday.value)
    }

    @Test
    fun `should throw BirthdayInFutureValidationException when date is in the future`() {
        // Arrange
        val futureDate = LocalDate.now().plusDays(1)

        // Act & Assert
        assertThrows<BirthdayInFutureValidationException> { Birthday.of(futureDate) }
    }

    @Test
    fun `should create Birthday from valid date string`() {
        // Arrange
        val dateString = "2000-01-01"
        val expectedDate = LocalDate.of(2000, 1, 1)

        // Act
        val birthday = Birthday.fromString(dateString)

        // Assert
        assertEquals(expectedDate, birthday.value)
    }

    @Test
    fun `should throw BirthdayInvalidFormatValidationException when date string is invalid`() {
        // Arrange
        val invalidDateString = "not-a-date"

        // Act & Assert
        assertThrows<BirthdayInvalidFormatValidationException> { Birthday.fromString(invalidDateString) }
    }

    @Test
    fun `should format date correctly when toString is called`() {
        // Arrange
        val date = LocalDate.of(2000, 1, 1)
        val birthday = Birthday.of(date)
        val expectedString = "2000-01-01"

        // Act
        val result = birthday.toString()

        // Assert
        assertEquals(expectedString, result)
    }
}
