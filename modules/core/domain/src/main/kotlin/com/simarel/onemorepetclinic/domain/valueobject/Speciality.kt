package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class Speciality private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): Speciality {
            if (value.isBlank()) {
                throw SpecialityIsEmptyValidationException()
            }
            return Speciality(value)
        }
    }
}

abstract class SpecialityValidationException(message: String): ValidationException(message)

class SpecialityIsEmptyValidationException : SpecialityValidationException("Специальность не может быть пустой")
