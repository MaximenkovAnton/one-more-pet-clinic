package com.simarel.onemorepetclinic.domain.valueobject.id

import java.util.UUID

@JvmInline
value class VisitId private constructor(override val value: UUID?) : EntityId {
    companion object {
        fun of(value: UUID): VisitId = VisitId(value)

        fun fromString(value: String): VisitId {
            return try {
                VisitId(UUID.fromString(value))
            } catch (e: IllegalArgumentException) {
                throw InvalidEntityIdFormatException()
            }
        }
    }

    override fun toString() = value.toString()
}
