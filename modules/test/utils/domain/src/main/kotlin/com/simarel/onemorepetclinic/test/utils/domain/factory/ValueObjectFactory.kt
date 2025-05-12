package com.simarel.onemorepetclinic.test.utils.domain.factory

import com.simarel.onemorepetclinic.domain.valueobject.Address
import com.simarel.onemorepetclinic.domain.valueobject.Birthday
import com.simarel.onemorepetclinic.domain.valueobject.City
import com.simarel.onemorepetclinic.domain.valueobject.Description
import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.PetName
import com.simarel.onemorepetclinic.domain.valueobject.PetType
import com.simarel.onemorepetclinic.domain.valueobject.Phone
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.domain.valueobject.VisitDate
import java.time.LocalDate

/**
 * Фабрика для создания value objects в тестах
 */
object ValueObjectFactory {

    fun createFirstName(value: String = "Иван"): FirstName = FirstName.of(value)

    fun createLastName(value: String = "Иванов"): LastName = LastName.of(value)

    fun createMiddleName(value: String = "Иванович"): MiddleName = MiddleName.of(value)

    fun createAddress(value: String = "ул. Пушкина, д. 10"): Address = Address.of(value)

    fun createCity(value: String = "Москва"): City = City.of(value)

    fun createPhone(value: String = "+7 (999) 123-45-67"): Phone = Phone.of(value)

    fun createPetName(value: String = "Барсик"): PetName = PetName.of(value)

    fun createBirthday(date: LocalDate = LocalDate.of(2020, 1, 1)): Birthday = Birthday.of(date)

    fun createPetType(type: PetType = PetType.CAT): PetType = type

    fun createSpeciality(value: String = "Хирургия"): Speciality = Speciality.of(value)

    fun createVisitDate(date: LocalDate = LocalDate.now().plusDays(7)): VisitDate = VisitDate.of(date)

    fun createDescription(value: String = "Ежегодный осмотр"): Description = Description.of(value)
}
