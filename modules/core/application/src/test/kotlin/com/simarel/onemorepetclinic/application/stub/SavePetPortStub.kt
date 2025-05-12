package com.simarel.onemorepetclinic.application.stub

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetRequest
import com.simarel.onemorepetclinic.port.output.pet.SavePetResponse

class SavePetPortStub : SavePetPort {
    private val pets = mutableMapOf<PetId, Pet>()
    private var lastSavedPet: Pet? = null

    override fun invoke(request: SavePetRequest): SavePetResponse {
        val pet = request.pet
        pets[pet.id] = pet
        lastSavedPet = pet
        return SavePetResponse(pet)
    }

    fun getLastSavedPet(): Pet? = lastSavedPet

    fun getPets(): Map<PetId, Pet> = pets.toMap()

    fun getPetById(id: PetId): Pet? = pets[id]
}
