package com.simarel.onemorepetclinic.domain.valueobject

import com.simarel.onemorepetclinic.domain.exception.ValidationException

@JvmInline
value class Address private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String): Address {
            if (value.isBlank()) {
                throw AddressIsEmptyValidationException()
            }
            return Address(value)
        }
    }
}

abstract class AddressValidationException(message: String) : ValidationException(message)

class AddressIsEmptyValidationException : AddressValidationException("Адрес не может быть пустым")
