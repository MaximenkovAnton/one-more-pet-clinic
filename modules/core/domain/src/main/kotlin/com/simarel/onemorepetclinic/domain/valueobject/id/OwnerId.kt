package com.simarel.onemorepetclinic.domain.valueobject.id

import java.util.UUID

@JvmInline
value class OwnerId private constructor(override val value: UUID?) : EntityId {
    companion object {
        fun of(value: UUID): OwnerId = OwnerId(value)

        fun fromString(value: String): OwnerId {
            return try {
                OwnerId(UUID.fromString(value))
            } catch (e: IllegalArgumentException) {
                throw InvalidEntityIdFormatException()
            }
        }
    }

    override fun toString() = value.toString()
}
