package com.simarel.onemorepetclinic.domain.valueobject.id

import java.util.UUID

@JvmInline
value class VetId private constructor(override val value: UUID?) : EntityId {
    companion object {
        fun of(value: UUID): VetId = VetId(value)

        fun fromString(value: String): VetId {
            return try {
                VetId(UUID.fromString(value))
            } catch (e: IllegalArgumentException) {
                throw InvalidEntityIdFormatException()
            }
        }
    }

    override fun toString() = value.toString()
}
