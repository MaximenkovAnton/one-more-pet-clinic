package com.simarel.onemorepetclinic.domain.valueobject.id

import java.util.UUID

@JvmInline
value class PetId private constructor(override val value: UUID?) : EntityId {
    companion object {
        fun of(value: UUID): PetId = PetId(value)

        fun fromString(value: String): PetId {
            return try {
                PetId(UUID.fromString(value))
            } catch (e: IllegalArgumentException) {
                throw InvalidEntityIdFormatException()
            }
        }
    }

    override fun toString() = value.toString()
}
