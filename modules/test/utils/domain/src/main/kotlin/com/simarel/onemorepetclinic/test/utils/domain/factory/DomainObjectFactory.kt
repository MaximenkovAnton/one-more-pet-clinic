package com.simarel.onemorepetclinic.test.utils.domain.factory

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.Visit
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
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId

/**
 * Фабрика для создания доменных объектов в тестах
 */
object DomainObjectFactory {

    fun createOwner(
        id: OwnerId = IdFactory.createOwnerId(),
        firstName: FirstName = ValueObjectFactory.createFirstName(),
        lastName: LastName = ValueObjectFactory.createLastName(),
        middleName: MiddleName = ValueObjectFactory.createMiddleName(),
        address: Address = ValueObjectFactory.createAddress(),
        city: City = ValueObjectFactory.createCity(),
        phone: Phone = ValueObjectFactory.createPhone(),
        pets: Set<Pet> = emptySet()
    ): Owner = Owner(id, firstName, lastName, middleName, address, city, phone, pets)

    fun createVet(
        id: VetId = IdFactory.createVetId(),
        firstName: FirstName = ValueObjectFactory.createFirstName("Петр"),
        lastName: LastName = ValueObjectFactory.createLastName("Петров"),
        middleName: MiddleName = ValueObjectFactory.createMiddleName("Петрович"),
        specialities: Set<Speciality> = setOf(ValueObjectFactory.createSpeciality())
    ): Vet = Vet(id, firstName, lastName, middleName, specialities)

    fun createPet(
        id: PetId = IdFactory.createPetId(),
        name: PetName = ValueObjectFactory.createPetName(),
        birthday: Birthday = ValueObjectFactory.createBirthday(),
        type: PetType = ValueObjectFactory.createPetType(),
        owner: Owner = createOwner()
    ): Pet = Pet(id, name, birthday, type, owner)

    fun createVisit(
        id: VisitId = IdFactory.createVisitId(),
        date: VisitDate = ValueObjectFactory.createVisitDate(),
        description: Description = ValueObjectFactory.createDescription(),
        pet: Pet = createPet()
    ): Visit = Visit(id, date, description, pet)
}
