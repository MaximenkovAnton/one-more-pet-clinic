package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class FirstName private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): FirstName {
            if (value.isBlank()) {
                throw FirstNameIsEmptyValidationException()
            }
            return FirstName(value)
        }
    }
}

abstract class FirstNameValidationException(message: String) : ValidationException(message)

class FirstNameIsEmptyValidationException : FirstNameValidationException("Имя не может быть пустым")
