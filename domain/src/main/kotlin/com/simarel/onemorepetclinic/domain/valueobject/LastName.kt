package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class LastName private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): LastName {
            if (value.isBlank()) {
                throw LastNameIsEmptyValidationException()
            }
            return LastName(value)
        }
    }
}

abstract class LastNameValidationException(message: String) : ValidationException(message)

class LastNameIsEmptyValidationException : LastNameValidationException("Фамилия не может быть пустой")
