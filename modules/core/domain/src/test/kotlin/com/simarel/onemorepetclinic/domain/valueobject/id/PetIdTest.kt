package com.simarel.onemorepetclinic.domain.valueobject.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class PetIdTest {

    @Test
    fun `should create PetId when valid UUID is provided`() {
        // Arrange
        val uuid = UUID.randomUUID()

        // Act
        val petId = PetId.of(uuid)

        // Assert
        assertEquals(uuid, petId.value)
    }

    @Test
    fun `should create PetId from valid UUID string`() {
        // Arrange
        val uuidString = "123e4567-e89b-12d3-a456-426614174000"
        val expectedUuid = UUID.fromString(uuidString)

        // Act
        val petId = PetId.fromString(uuidString)

        // Assert
        assertEquals(expectedUuid, petId.value)
    }

    @Test
    fun `should return string representation of UUID when toString is called`() {
        // Arrange
        val uuid = UUID.randomUUID()
        val petId = PetId.of(uuid)

        // Act
        val result = petId.toString()

        // Assert
        assertEquals(uuid.toString(), result)
    }
}
