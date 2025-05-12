package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.PetType
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.pet.FetchPetPort
import com.simarel.onemorepetclinic.port.output.pet.FetchPetRequest
import com.simarel.onemorepetclinic.port.output.pet.FetchPetResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchPetPortStub : FetchPetPort {
    private val pets = mutableMapOf<PetId, Pet>()

    init {
        val owner = DomainObjectFactory.createOwner()

        val pet1 = DomainObjectFactory.createPet(
            name = ValueObjectFactory.createPetName("Барсик"),
            type = PetType.CAT,
            owner = owner
        )
        val pet2 = DomainObjectFactory.createPet(
            name = ValueObjectFactory.createPetName("Мурзик"),
            type = PetType.CAT,
            owner = owner
        )
        val pet3 = DomainObjectFactory.createPet(
            name = ValueObjectFactory.createPetName("Шарик"),
            type = PetType.DOG,
            owner = owner
        )

        pets[pet1.id] = pet1
        pets[pet2.id] = pet2
        pets[pet3.id] = pet3
    }

    override fun invoke(request: FetchPetRequest): FetchPetResponse {
        return FetchPetResponse(pets[request.id])
    }

    fun getPets(): Map<PetId, Pet> = pets.toMap()

    fun getPetById(id: PetId): Pet? = pets[id]

    fun addPet(pet: Pet) {
        pets[pet.id] = pet
    }
}
