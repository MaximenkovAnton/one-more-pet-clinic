package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SpecialityTest {

    @Test
    fun `should create Speciality when value is not blank`() {
        // Arrange
        val specialityValue = "Хирургия"

        // Act
        val speciality = Speciality.of(specialityValue)

        // Assert
        assertEquals(specialityValue, speciality.value)
    }

    @Test
    fun `should throw SpecialityIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<SpecialityIsEmptyValidationException> { Speciality.of(emptyValue) }

        assertThrows<SpecialityIsEmptyValidationException> { Speciality.of(blankValue) }
    }
}
