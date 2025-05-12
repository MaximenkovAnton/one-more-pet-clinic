package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@JvmInline
value class Birthday private constructor(override val value: LocalDate) : ValueObject<LocalDate> {
    companion object {
        private val DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE

        fun of(value: LocalDate): Birthday {
            if (value.isAfter(LocalDate.now())) {
                throw BirthdayInFutureValidationException()
            }
            return Birthday(value)
        }

        fun fromString(value: String): Birthday {
            try {
                val date = LocalDate.parse(value, DATE_FORMATTER)
                return of(date)
            } catch (e: DateTimeParseException) {
                throw BirthdayInvalidFormatValidationException()
            }
        }
    }

    override fun toString() = value.format(DATE_FORMATTER)
}

abstract class BirthdayValidationException(message: String) : ValidationException(message)

class BirthdayInFutureValidationException : BirthdayValidationException("Дата рождения не может быть в будущем")
class BirthdayInvalidFormatValidationException : BirthdayValidationException("Неверный формат даты рождения")
