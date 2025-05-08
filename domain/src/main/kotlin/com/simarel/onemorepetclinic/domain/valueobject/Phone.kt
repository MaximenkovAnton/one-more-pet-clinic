package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class Phone private constructor(override val value: String) : ValueObject<String> {
    companion object {
        // Поддерживает российские (11 цифр) и белорусские (12 цифр) номера телефонов
        private val PHONE_REGEX = Regex("^\\+?\\d{11,12}$")
        private val CLEANUP_REGEX = Regex("[\\s()-]")

        fun of(value: String): Phone {
            if (value.isBlank()) {
                throw PhoneIsEmptyValidationException()
            }
            
            // Сохраняем плюс в начале, если он есть, и удаляем только пробелы, скобки и дефисы
            val cleanedValue = value.replace(CLEANUP_REGEX, "")
            
            if (!PHONE_REGEX.matches(cleanedValue)) {
                throw PhoneInvalidFormatValidationException()
            }
            
            return Phone(cleanedValue)
        }
    }
}

abstract class PhoneValidationException(message: String) : ValidationException(message)

class PhoneIsEmptyValidationException : PhoneValidationException("Телефон не может быть пустым")
class PhoneInvalidFormatValidationException : PhoneValidationException("Неверный формат телефона")
