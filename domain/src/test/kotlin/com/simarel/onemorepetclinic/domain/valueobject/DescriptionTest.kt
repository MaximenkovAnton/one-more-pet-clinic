package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DescriptionTest {

    @Test
    fun `should create Description when value is not blank`() {
        // Arrange
        val descriptionValue = "Описание визита к ветеринару"

        // Act
        val description = Description.of(descriptionValue)

        // Assert
        assertEquals(descriptionValue, description.value)
    }

    @Test
    fun `should throw DescriptionIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<DescriptionIsEmptyValidationException> { Description.of(emptyValue) }

        assertThrows<DescriptionIsEmptyValidationException> { Description.of(blankValue) }
    }
}
