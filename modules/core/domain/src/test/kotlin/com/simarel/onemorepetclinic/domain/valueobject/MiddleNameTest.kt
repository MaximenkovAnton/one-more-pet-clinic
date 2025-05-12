package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MiddleNameTest {

    @Test
    fun `should create MiddleName when value is not null`() {
        // Arrange
        val middleNameValue = "Иванович"

        // Act
        val middleName = MiddleName.of(middleNameValue)

        // Assert
        assertEquals(middleNameValue, middleName.value)
    }

    @Test
    fun `should create MiddleName with empty string when value is null`() {
        // Arrange
        val nullValue: String? = null

        // Act
        val middleName = MiddleName.of(nullValue)

        // Assert
        assertEquals("", middleName.value)
    }
}
