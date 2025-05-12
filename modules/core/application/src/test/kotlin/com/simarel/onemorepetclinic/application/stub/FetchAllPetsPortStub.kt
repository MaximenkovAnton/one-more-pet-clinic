package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsPort
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsRequest
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsResponse
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory

class FetchAllPetsPortStub : FetchAllPetsPort {
    private val pets = mutableMapOf<PetId, Pet>()
    private val petsByOwner = mutableMapOf<OwnerId, MutableList<Pet>>()
    private var lastPaginationInfo: PaginationInfo? = null
    private var lastOwnerId: OwnerId? = null

    init {
        val owner1 = DomainObjectFactory.createOwner(
            firstName = ValueObjectFactory.createFirstName("Иван"),
            lastName = ValueObjectFactory.createLastName("Иванов")
        )
        val owner2 = DomainObjectFactory.createOwner(
            firstName = ValueObjectFactory.createFirstName("Петр"),
            lastName = ValueObjectFactory.createLastName("Петров")
        )

        val owner1Pets = mutableListOf<Pet>()
        for (i in 1..3) {
            val pet = DomainObjectFactory.createPet(
                name = ValueObjectFactory.createPetName("Питомец$i-1"),
                owner = owner1
            )
            pets[pet.id] = pet
            owner1Pets.add(pet)
        }
        petsByOwner[owner1.id] = owner1Pets

        val owner2Pets = mutableListOf<Pet>()
        for (i in 1..2) {
            val pet = DomainObjectFactory.createPet(
                name = ValueObjectFactory.createPetName("Питомец$i-2"),
                owner = owner2
            )
            pets[pet.id] = pet
            owner2Pets.add(pet)
        }
        petsByOwner[owner2.id] = owner2Pets
    }

    override fun invoke(request: FetchAllPetsRequest): FetchAllPetsResponse {
        lastPaginationInfo = request.paginationInfo
        lastOwnerId = request.ownerId

        val pageNumber = request.paginationInfo.pageNumber.value
        val pageSize = request.paginationInfo.pageSize.value
        val startIndex = pageNumber * pageSize
        val endIndex = startIndex + pageSize

        val filteredPets = if (request.ownerId != null) {
            petsByOwner[request.ownerId]?.toList() ?: emptyList()
        } else {
            pets.values.toList()
        }

        val pagedPets = if (startIndex < filteredPets.size) {
            filteredPets.subList(startIndex, minOf(endIndex, filteredPets.size))
        } else {
            emptyList()
        }

        return FetchAllPetsResponse(
            pets = pagedPets,
            count = Count.of(filteredPets.size.toLong())
        )
    }

    fun getLastPaginationInfo(): PaginationInfo? = lastPaginationInfo

    fun getLastOwnerId(): OwnerId? = lastOwnerId

    fun getPets(): Map<PetId, Pet> = pets.toMap()

    fun getPetsByOwner(ownerId: OwnerId): List<Pet> = petsByOwner[ownerId]?.toList() ?: emptyList()

    fun addPet(pet: Pet) {
        pets[pet.id] = pet
        petsByOwner.getOrPut(pet.owner.id) { mutableListOf() }.add(pet)
    }

    fun removePet(id: PetId) {
        val pet = pets[id] ?: return
        pets.remove(id)
        petsByOwner[pet.owner.id]?.remove(pet)
    }
}
