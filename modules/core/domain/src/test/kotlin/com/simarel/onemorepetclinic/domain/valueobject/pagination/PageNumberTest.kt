package com.simarel.onemorepetclinic.domain.valueobject.pagination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PageNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10, 100, Int.MAX_VALUE])
    fun `should create PageNumber when value is not negative`(value: Int) {
        // Act
        val pageNumber = PageNumber.of(value)

        // Assert
        assertEquals(value, pageNumber.value)
    }

    @Test
    fun `should throw NegativePageNumberValidationException when value is negative`() {
        // Arrange
        val negativeValue = -1

        // Act & Assert
        assertThrows<NegativePageNumberValidationException> { PageNumber.of(negativeValue) }
    }

    @Test
    fun `should return string representation of value when toString is called`() {
        // Arrange
        val value = 5
        val pageNumber = PageNumber.of(value)

        // Act
        val result = pageNumber.toString()

        // Assert
        assertEquals(value.toString(), result)
    }
}
