package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class Description private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): Description {
            if (value.isBlank()) {
                throw DescriptionIsEmptyValidationException()
            }
            return Description(value)
        }
    }
}

abstract class DescriptionValidationException(message: String) : ValidationException(message)

class DescriptionIsEmptyValidationException : DescriptionValidationException("Описание не может быть пустым")
