package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PetTypeTest {

    @Test
    fun `should convert string to PetType when string is valid`() {
        // Arrange & Act & Assert
        assertEquals(PetType.DOG, PetType.fromString("DOG"))
        assertEquals(PetType.CAT, PetType.fromString("CAT"))
        assertEquals(PetType.BIRD, PetType.fromString("BIRD"))
        assertEquals(PetType.REPTILE, PetType.fromString("REPTILE"))
        assertEquals(PetType.FISH, PetType.fromString("FISH"))
        assertEquals(PetType.OTHER, PetType.fromString("OTHER"))
    }

    @Test
    fun `should convert lowercase string to PetType when string is valid`() {
        // Arrange & Act & Assert
        assertEquals(PetType.DOG, PetType.fromString("dog"))
        assertEquals(PetType.CAT, PetType.fromString("cat"))
        assertEquals(PetType.BIRD, PetType.fromString("bird"))
        assertEquals(PetType.REPTILE, PetType.fromString("reptile"))
        assertEquals(PetType.FISH, PetType.fromString("fish"))
        assertEquals(PetType.OTHER, PetType.fromString("other"))
    }

    @Test
    fun `should throw PetTypeUnknownValidationException when string is unknown`() {
        // Arrange
        val unknownType = "UNKNOWN"

        // Act & Assert
        val exception = assertThrows<PetTypeUnknownValidationException> { PetType.fromString(unknownType) }

        assertEquals("Неизвестный тип питомца: $unknownType", exception.message)
    }
}
