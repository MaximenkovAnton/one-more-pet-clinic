package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FirstNameTest {

    @Test
    fun `should create FirstName when value is not blank`() {
        // Arrange
        val firstNameValue = "Иван"

        // Act
        val firstName = FirstName.of(firstNameValue)

        // Assert
        assertEquals(firstNameValue, firstName.value)
    }

    @Test
    fun `should throw FirstNameIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<FirstNameIsEmptyValidationException> { FirstName.of(emptyValue) }

        assertThrows<FirstNameIsEmptyValidationException> { FirstName.of(blankValue) }
    }
}
