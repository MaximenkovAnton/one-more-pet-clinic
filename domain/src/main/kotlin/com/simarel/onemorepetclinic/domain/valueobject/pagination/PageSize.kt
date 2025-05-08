package com.simarel.onemorepetclinic.domain.valueobject.pagination

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import com.simarel.onemorepetclinic.domain.valueobject.ValueObject

@JvmInline
value class PageSize private constructor(override val value: Int) : ValueObject<Int> {
    companion object {
        private const val MAX_PAGE_SIZE = 100

        fun of(value: Int): PageSize {
            if (value <= 0) {
                throw InvalidPageSizeException("Размер страницы должен быть положительным числом")
            }
            if (value > MAX_PAGE_SIZE) {
                throw InvalidPageSizeException("Размер страницы не может превышать $MAX_PAGE_SIZE")
            }
            return PageSize(value)
        }
    }

    override fun toString() = value.toString()
}

class InvalidPageSizeException(message: String) : ValidationException(message)
