package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CityTest {

    @Test
    fun `should create City when value is not blank`() {
        // Arrange
        val cityValue = "Москва"

        // Act
        val city = City.of(cityValue)

        // Assert
        assertEquals(cityValue, city.value)
    }

    @Test
    fun `should throw CityIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<CityIsEmptyValidationException> { City.of(emptyValue) }

        assertThrows<CityIsEmptyValidationException> { City.of(blankValue) }
    }
}
