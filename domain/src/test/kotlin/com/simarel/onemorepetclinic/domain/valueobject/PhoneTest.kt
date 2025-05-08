package com.simarel.onemorepetclinic.domain.valueobject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PhoneTest {

    @ParameterizedTest
    @CsvSource(
        // Белорусские номера (12 цифр)
        "+ 375 (33) 123-45-67, +375331234567",
        "+375291234567, +375291234567",
        "375 44 123-45-67, 375441234567",
        // Российские номера (11 цифр)
        "+7 (999) 123-45-67, +79991234567",
        "8(495)1234567, 84951234567",
        "+7 916 123-45-67, +79161234567",
        "8-903-123-45-67, 89031234567",
        "+7(925)123-4567, +79251234567"
    )
    fun `should create Phone when value is valid`(input: String, expected: String) {
        // Act
        val phone = Phone.of(input)
        
        // Assert
        assertEquals(expected, phone.value)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "", // пустой номер
        "      ", // одни пробелы
    ])
    fun `should throw PhoneIsEmptyValidationException when value is blank`(value: String) {
        assertThrows<PhoneIsEmptyValidationException> { Phone.of(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "+phone", // не номер
        "+7912345678901234567890", // слишком длинный
        "123456", // слишком короткий
        "++79031234567", // двойной плюс
        // неверные форматы
        "7 (999) 123-45+67",
        "7 (999) 123-45&67",
        "7 (999) 123-45-as",
    ])
    fun `should throw PhoneInvalidFormatValidationException when format is invalid`(invalidPhone: String) {
        // Act & Assert
        assertThrows<PhoneInvalidFormatValidationException> { Phone.of(invalidPhone) }
    }
}
