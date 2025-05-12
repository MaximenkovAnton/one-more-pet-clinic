package com.simarel.onemorepetclinic.domain.valueobject.id

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EntityIdTest {

    @Test
    fun `should throw InvalidEntityIdFormatException when UUID string is invalid`() {
        // Arrange
        val invalidUuidString = "not-a-uuid"

        // Act & Assert
        assertThrows<InvalidEntityIdFormatException> { OwnerId.fromString(invalidUuidString) }
        assertThrows<InvalidEntityIdFormatException> { PetId.fromString(invalidUuidString) }
        assertThrows<InvalidEntityIdFormatException> { VetId.fromString(invalidUuidString) }
        assertThrows<InvalidEntityIdFormatException> { VisitId.fromString(invalidUuidString) }
    }
}
