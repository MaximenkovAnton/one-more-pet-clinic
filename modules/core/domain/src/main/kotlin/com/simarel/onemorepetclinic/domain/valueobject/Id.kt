package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import java.util.UUID

@JvmInline
value class Id private constructor(override val value: UUID?) : ValueObject<UUID?> {
    companion object {
        fun generate(): Id = Id(UUID.randomUUID())

        fun of(value: UUID): Id = Id(value)

        fun fromString(value: String): Id {
            return try {
                Id(UUID.fromString(value))
            } catch (e: IllegalArgumentException) {
                throw InvalidIdFormatException()
            }
        }
    }

    override fun toString() = value.toString()
}
abstract class IdValidationException(message: String): ValidationException(message)

class InvalidIdFormatException : IdValidationException("Неверный формат идентификатора")
