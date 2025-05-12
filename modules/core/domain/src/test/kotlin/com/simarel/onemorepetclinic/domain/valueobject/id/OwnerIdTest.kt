package com.simarel.onemorepetclinic.domain.valueobject.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class OwnerIdTest {

    @Test
    fun `should create OwnerId when valid UUID is provided`() {
        // Arrange
        val uuid = UUID.randomUUID()

        // Act
        val ownerId = OwnerId.of(uuid)

        // Assert
        assertEquals(uuid, ownerId.value)
    }

    @Test
    fun `should create OwnerId from valid UUID string`() {
        // Arrange
        val uuidString = "123e4567-e89b-12d3-a456-426614174000"
        val expectedUuid = UUID.fromString(uuidString)

        // Act
        val ownerId = OwnerId.fromString(uuidString)

        // Assert
        assertEquals(expectedUuid, ownerId.value)
    }

    @Test
    fun `should return string representation of UUID when toString is called`() {
        // Arrange
        val uuid = UUID.randomUUID()
        val ownerId = OwnerId.of(uuid)

        // Act
        val result = ownerId.toString()

        // Assert
        assertEquals(uuid.toString(), result)
    }
}
