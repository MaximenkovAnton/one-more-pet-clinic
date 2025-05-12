package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class Count private constructor(override val value: Long) : ValueObject<Long> {
    companion object {
        fun of(value: Long): Count {
            if (value < 0) {
                throw NegativeCountValidationException()
            }
            return Count(value)
        }
    }
}

abstract class CountValidationException(message: String) : ValidationException(message)

class NegativeCountValidationException : CountValidationException("Количество не может быть отрицательным")
