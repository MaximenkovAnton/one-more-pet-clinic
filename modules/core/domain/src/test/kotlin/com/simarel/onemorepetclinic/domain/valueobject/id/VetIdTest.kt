package com.simarel.onemorepetclinic.domain.valueobject.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class VetIdTest {

    @Test
    fun `should create VetId when valid UUID is provided`() {
        // Arrange
        val uuid = UUID.randomUUID()

        // Act
        val vetId = VetId.of(uuid)

        // Assert
        assertEquals(uuid, vetId.value)
    }

    @Test
    fun `should create VetId from valid UUID string`() {
        // Arrange
        val uuidString = "123e4567-e89b-12d3-a456-426614174000"
        val expectedUuid = UUID.fromString(uuidString)

        // Act
        val vetId = VetId.fromString(uuidString)

        // Assert
        assertEquals(expectedUuid, vetId.value)
    }

    @Test
    fun `should return string representation of UUID when toString is called`() {
        // Arrange
        val uuid = UUID.randomUUID()
        val vetId = VetId.of(uuid)

        // Act
        val result = vetId.toString()

        // Assert
        assertEquals(uuid.toString(), result)
    }
}
