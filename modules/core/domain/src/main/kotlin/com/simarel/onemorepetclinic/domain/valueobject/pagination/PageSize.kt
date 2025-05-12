package com.simarel.onemorepetclinic.domain.valueobject.pagination

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import com.simarel.onemorepetclinic.domain.valueobject.ValueObject

private const val MAX_PAGE_SIZE = 100

@JvmInline
value class PageSize private constructor(override val value: Int) : ValueObject<Int> {
    companion object {

        fun of(value: Int): PageSize {
            if (value <= 0) {
                throw NegativePageSizeValidationException()
            }
            if (value > MAX_PAGE_SIZE) {
                throw TooBigPageSizeValidationException()
            }
            return PageSize(value)
        }
    }

    override fun toString() = value.toString()
}

abstract class PageSizeValidationException(message: String) : ValidationException(message)

class NegativePageSizeValidationException: PageSizeValidationException("Размер страницы должен быть положительным числом")
class TooBigPageSizeValidationException: PageSizeValidationException("Размер страницы не может превышать $MAX_PAGE_SIZE")