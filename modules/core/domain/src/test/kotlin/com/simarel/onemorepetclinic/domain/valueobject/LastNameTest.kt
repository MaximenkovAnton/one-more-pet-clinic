package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LastNameTest {

    @Test
    fun `should create LastName when value is not blank`() {
        // Arrange
        val lastNameValue = "Иванов"

        // Act
        val lastName = LastName.of(lastNameValue)

        // Assert
        assertEquals(lastNameValue, lastName.value)
    }

    @Test
    fun `should throw LastNameIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<LastNameIsEmptyValidationException> { LastName.of(emptyValue) }

        assertThrows<LastNameIsEmptyValidationException> { LastName.of(blankValue) }
    }
}
