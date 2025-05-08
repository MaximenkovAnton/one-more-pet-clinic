package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PetNameTest {

    @Test
    fun `should create PetName when value is not blank`() {
        // Arrange
        val petNameValue = "Барсик"

        // Act
        val petName = PetName.of(petNameValue)

        // Assert
        assertEquals(petNameValue, petName.value)
    }

    @Test
    fun `should throw PetNameIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<PetNameIsEmptyValidationException> { PetName.of(emptyValue) }

        assertThrows<PetNameIsEmptyValidationException> { PetName.of(blankValue) }
    }
}
