package com.simarel.onemorepetclinic.domain.valueobject.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class VisitIdTest {

    @Test
    fun `should create VisitId when valid UUID is provided`() {
        // Arrange
        val uuid = UUID.randomUUID()

        // Act
        val visitId = VisitId.of(uuid)

        // Assert
        assertEquals(uuid, visitId.value)
    }

    @Test
    fun `should create VisitId from valid UUID string`() {
        // Arrange
        val uuidString = "123e4567-e89b-12d3-a456-426614174000"
        val expectedUuid = UUID.fromString(uuidString)

        // Act
        val visitId = VisitId.fromString(uuidString)

        // Assert
        assertEquals(expectedUuid, visitId.value)
    }

    @Test
    fun `should return string representation of UUID when toString is called`() {
        // Arrange
        val uuid = UUID.randomUUID()
        val visitId = VisitId.of(uuid)

        // Act
        val result = visitId.toString()

        // Assert
        assertEquals(uuid.toString(), result)
    }
}
