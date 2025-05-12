package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class City private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): City {
            if (value.isBlank()) {
                throw CityIsEmptyValidationException()
            }
            return City(value)
        }
    }
}

abstract class CityValidationException(message: String) : ValidationException(message)

class CityIsEmptyValidationException : CityValidationException("Город не может быть пустым")
