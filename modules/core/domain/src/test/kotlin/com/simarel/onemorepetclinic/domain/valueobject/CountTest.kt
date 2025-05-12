package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CountTest {

    @ParameterizedTest
    @ValueSource(longs = [0, 1, 10, 100, Long.MAX_VALUE])
    fun `should create Count when value is not negative`(value: Long) {
        // Act
        val count = Count.of(value)

        // Assert
        assertEquals(value, count.value)
    }

    @Test
    fun `should throw NegativeCountValidationException when value is negative`() {
        // Arrange
        val negativeValue = -1L

        // Act & Assert
        assertThrows<NegativeCountValidationException> { Count.of(negativeValue) }
    }
}
