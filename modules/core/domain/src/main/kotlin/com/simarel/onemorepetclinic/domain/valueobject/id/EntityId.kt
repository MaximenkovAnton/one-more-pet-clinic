package com.simarel.onemorepetclinic.domain.valueobject.id

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import com.simarel.onemorepetclinic.domain.valueobject.ValueObject
import java.util.UUID

/**
 * Базовый интерфейс для всех идентификаторов сущностей
 */
interface EntityId : ValueObject<UUID?> {
    override val value: UUID?

    override fun toString(): String
}

abstract class EntityIdValidationException(message: String) : ValidationException(message)

class InvalidEntityIdFormatException : EntityIdValidationException("Неверный формат идентификатора")
