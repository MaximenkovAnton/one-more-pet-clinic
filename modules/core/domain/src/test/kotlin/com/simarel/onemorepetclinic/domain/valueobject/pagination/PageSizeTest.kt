package com.simarel.onemorepetclinic.domain.valueobject.pagination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PageSizeTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 50, 100])
    fun `should create PageSize when value is positive and not too big`(value: Int) {
        // Act
        val pageSize = PageSize.of(value)

        // Assert
        assertEquals(value, pageSize.value)
    }

    @Test
    fun `should throw NegativePageSizeValidationException when value is zero or negative`() {
        // Arrange
        val zeroValue = 0
        val negativeValue = -1

        // Act & Assert
        assertThrows<NegativePageSizeValidationException> { PageSize.of(zeroValue) }
        assertThrows<NegativePageSizeValidationException> { PageSize.of(negativeValue) }
    }

    @Test
    fun `should throw TooBigPageSizeValidationException when value is greater than max allowed`() {
        // Arrange
        val tooBigValue = 101 // Assuming MAX_PAGE_SIZE is 100

        // Act & Assert
        assertThrows<TooBigPageSizeValidationException> { PageSize.of(tooBigValue) }
    }

    @Test
    fun `should return string representation of value when toString is called`() {
        // Arrange
        val value = 20
        val pageSize = PageSize.of(value)

        // Act
        val result = pageSize.toString()

        // Assert
        assertEquals(value.toString(), result)
    }
}
