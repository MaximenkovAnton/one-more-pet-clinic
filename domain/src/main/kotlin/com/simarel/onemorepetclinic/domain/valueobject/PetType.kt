package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

enum class PetType {
    DOG,
    CAT,
    BIRD,
    REPTILE,
    FISH,
    OTHER;

    companion object {
        fun fromString(value: String): PetType {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                throw PetTypeUnknownValidationException(value)
            }
        }
    }
}

abstract class PetTypeValidationException(message: String) : ValidationException(message)

class PetTypeUnknownValidationException(type: String) : PetTypeValidationException("Неизвестный тип питомца: $type")
