package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AddressTest {

    @Test
    fun `should create Address when value is not blank`() {
        // Arrange
        val addressValue = "ул. Пушкина, д. 10"

        // Act
        val address = Address.of(addressValue)

        // Assert
        assertEquals(addressValue, address.value)
    }

    @Test
    fun `should throw AddressIsEmptyValidationException when value is blank`() {
        // Arrange
        val emptyValue = ""
        val blankValue = "   "

        // Act & Assert
        assertThrows<AddressIsEmptyValidationException> { Address.of(emptyValue) }

        assertThrows<AddressIsEmptyValidationException> { Address.of(blankValue) }
    }
}
