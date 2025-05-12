package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class IdTest {

    @Test
    fun `should generate Id with random UUID when generate is called`() {
        // Act
        val id = Id.generate()

        // Assert
        assertNotNull(id.value)
    }

    @Test
    fun `should create Id when valid UUID is provided`() {
        // Arrange
        val uuid = UUID.randomUUID()

        // Act
        val id = Id.of(uuid)

        // Assert
        assertEquals(uuid, id.value)
    }

    @Test
    fun `should create Id from valid UUID string`() {
        // Arrange
        val uuidString = "123e4567-e89b-12d3-a456-426614174000"
        val expectedUuid = UUID.fromString(uuidString)

        // Act
        val id = Id.fromString(uuidString)

        // Assert
        assertEquals(expectedUuid, id.value)
    }

    @Test
    fun `should throw InvalidIdFormatException when UUID string is invalid`() {
        // Arrange
        val invalidUuidString = "not-a-uuid"

        // Act & Assert
        assertThrows<InvalidIdFormatException> { Id.fromString(invalidUuidString) }
    }

    @Test
    fun `should return string representation of UUID when toString is called`() {
        // Arrange
        val uuid = UUID.randomUUID()
        val id = Id.of(uuid)

        // Act
        val result = id.toString()

        // Assert
        assertEquals(uuid.toString(), result)
    }
}
