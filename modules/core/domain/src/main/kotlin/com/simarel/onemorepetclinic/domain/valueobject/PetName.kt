package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class PetName private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): PetName {
            if (value.isBlank()) {
                throw PetNameIsEmptyValidationException()
            }
            return PetName(value)
        }
    }
}

abstract class PetNameValidationException(message: String) : ValidationException(message)

class PetNameIsEmptyValidationException : PetNameValidationException("Имя питомца не может быть пустым")
