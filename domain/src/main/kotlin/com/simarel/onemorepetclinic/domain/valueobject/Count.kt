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

class NegativeCountValidationException : ValidationException("Количество не может быть отрицательным")
