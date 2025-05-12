package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@JvmInline
value class VisitDate private constructor(override val value: LocalDate) : ValueObject<LocalDate> {
    companion object {
        private val DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE

        fun of(value: LocalDate): VisitDate {
            return VisitDate(value)
        }

        fun fromString(value: String): VisitDate {
            try {
                val date = LocalDate.parse(value, DATE_FORMATTER)
                return of(date)
            } catch (e: DateTimeParseException) {
                throw VisitDateInvalidFormatValidationException()
            }
        }
    }

    override fun toString() = value.format(DATE_FORMATTER)
}

abstract class VisitDateValidationException(message: String) : ValidationException(message)

class VisitDateInvalidFormatValidationException : VisitDateValidationException("Неверный формат даты визита")
