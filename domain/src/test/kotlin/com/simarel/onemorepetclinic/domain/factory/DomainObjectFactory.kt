package com.simarel.onemorepetclinic.domain.factory

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.Address
import com.simarel.onemorepetclinic.domain.valueobject.Birthday
import com.simarel.onemorepetclinic.domain.valueobject.City
import com.simarel.onemorepetclinic.domain.valueobject.Description
import com.simarel.onemorepetclinic.domain.valueobject.FirstName
import com.simarel.onemorepetclinic.domain.valueobject.Id
import com.simarel.onemorepetclinic.domain.valueobject.LastName
import com.simarel.onemorepetclinic.domain.valueobject.MiddleName
import com.simarel.onemorepetclinic.domain.valueobject.PetName
import com.simarel.onemorepetclinic.domain.valueobject.PetType
import com.simarel.onemorepetclinic.domain.valueobject.Phone
import com.simarel.onemorepetclinic.domain.valueobject.Speciality
import com.simarel.onemorepetclinic.domain.valueobject.VisitDate

/**
 * Фабрика для создания доменных объектов в тестах
 */
object DomainObjectFactory {

    fun createOwner(
        id: Id = ValueObjectFactory.createId(),
        firstName: FirstName = ValueObjectFactory.createFirstName(),
        lastName: LastName = ValueObjectFactory.createLastName(),
        middleName: MiddleName = ValueObjectFactory.createMiddleName(),
        address: Address = ValueObjectFactory.createAddress(),
        city: City = ValueObjectFactory.createCity(),
        phone: Phone = ValueObjectFactory.createPhone(),
        pets: Set<Pet> = emptySet()
    ): Owner = Owner(id, firstName, lastName, middleName, address, city, phone, pets)

    fun createVet(
        id: Id = ValueObjectFactory.createId(),
        firstName: FirstName = ValueObjectFactory.createFirstName("Петр"),
        lastName: LastName = ValueObjectFactory.createLastName("Петров"),
        middleName: MiddleName = ValueObjectFactory.createMiddleName("Петрович"),
        specialities: Set<Speciality> = setOf(ValueObjectFactory.createSpeciality())
    ): Vet = Vet(id, firstName, lastName, middleName, specialities)

    fun createPet(
        id: Id = ValueObjectFactory.createId(),
        name: PetName = ValueObjectFactory.createPetName(),
        birthday: Birthday = ValueObjectFactory.createBirthday(),
        type: PetType = ValueObjectFactory.createPetType(),
        owner: Owner = createOwner()
    ): Pet = Pet(id, name, birthday, type, owner)

    fun createVisit(
        id: Id = ValueObjectFactory.createId(),
        date: VisitDate = ValueObjectFactory.createVisitDate(),
        description: Description = ValueObjectFactory.createDescription(),
        pet: Pet = createPet()
    ): Visit = Visit(id, date, description, pet)
}
