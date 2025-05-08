package com.simarel.onemorepetclinic.domain.valueobject.pagination

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import com.simarel.onemorepetclinic.domain.valueobject.ValueObject

@JvmInline
value class PageNumber private constructor(override val value: Int) : ValueObject<Int> {
    companion object {
        fun of(value: Int): PageNumber {
            if (value < 0) {
                throw InvalidPageNumberException("Номер страницы не может быть отрицательным")
            }
            return PageNumber(value)
        }
    }

    override fun toString() = value.toString()
}

class InvalidPageNumberException(message: String) : ValidationException(message)
