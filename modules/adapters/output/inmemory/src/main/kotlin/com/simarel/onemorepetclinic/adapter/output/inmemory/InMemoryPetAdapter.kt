package com.simarel.onemorepetclinic.adapter.output.inmemory

import com.simarel.onemorepetclinic.domain.Pet
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsPort
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsRequest
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsResponse
import com.simarel.onemorepetclinic.port.output.pet.FetchPetPort
import com.simarel.onemorepetclinic.port.output.pet.FetchPetRequest
import com.simarel.onemorepetclinic.port.output.pet.FetchPetResponse
import com.simarel.onemorepetclinic.port.output.pet.RemovePetPort
import com.simarel.onemorepetclinic.port.output.pet.RemovePetRequest
import com.simarel.onemorepetclinic.port.output.pet.RemovePetResponse
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetRequest
import com.simarel.onemorepetclinic.port.output.pet.SavePetResponse

class InMemoryPetAdapter {
    private val storage = InMemoryStorage<PetId, Pet>()

    class SavePetAdapter(private val storage: InMemoryStorage<PetId, Pet>) : SavePetPort {
        override fun invoke(request: SavePetRequest): SavePetResponse {
            val savedPet = storage.save(request.pet.id, request.pet)
            return SavePetResponse(savedPet)
        }
    }

    class FetchPetAdapter(private val storage: InMemoryStorage<PetId, Pet>) : FetchPetPort {
        override fun invoke(request: FetchPetRequest): FetchPetResponse {
            val pet = storage.findById(request.id)
            return FetchPetResponse(pet)
        }
    }

    class FetchAllPetsAdapter(private val storage: InMemoryStorage<PetId, Pet>) : FetchAllPetsPort {
        override fun invoke(request: FetchAllPetsRequest): FetchAllPetsResponse {
            val (pets, count) = storage.findAll(request.paginationInfo)
            return FetchAllPetsResponse(pets, count)
        }
    }

    class RemovePetAdapter(private val storage: InMemoryStorage<PetId, Pet>) : RemovePetPort {
        override fun invoke(request: RemovePetRequest): RemovePetResponse {
            storage.delete(request.id)
            return RemovePetResponse()
        }
    }

    fun savePetPort(): SavePetPort = SavePetAdapter(storage)
    fun fetchPetPort(): FetchPetPort = FetchPetAdapter(storage)
    fun fetchAllPetsPort(): FetchAllPetsPort = FetchAllPetsAdapter(storage)
    fun removePetPort(): RemovePetPort = RemovePetAdapter(storage)
}
