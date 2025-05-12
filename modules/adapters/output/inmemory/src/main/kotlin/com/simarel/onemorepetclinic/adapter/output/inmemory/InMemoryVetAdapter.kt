package com.simarel.onemorepetclinic.adapter.output.inmemory

import com.simarel.onemorepetclinic.domain.Vet
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsPort
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsRequest
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsResponse
import com.simarel.onemorepetclinic.port.output.vet.FetchVetPort
import com.simarel.onemorepetclinic.port.output.vet.FetchVetRequest
import com.simarel.onemorepetclinic.port.output.vet.FetchVetResponse
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetPort
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetRequest
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetResponse
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetRequest
import com.simarel.onemorepetclinic.port.output.vet.SaveVetResponse

class InMemoryVetAdapter {
    private val storage = InMemoryStorage<VetId, Vet>()

    class SaveVetAdapter(private val storage: InMemoryStorage<VetId, Vet>) : SaveVetPort {
        override fun invoke(request: SaveVetRequest): SaveVetResponse {
            val savedVet = storage.save(request.vet.id, request.vet)
            return SaveVetResponse(savedVet)
        }
    }

    class FetchVetAdapter(private val storage: InMemoryStorage<VetId, Vet>) : FetchVetPort {
        override fun invoke(request: FetchVetRequest): FetchVetResponse {
            val vet = storage.findById(request.id)
            return FetchVetResponse(vet)
        }
    }

    class FetchAllVetsAdapter(private val storage: InMemoryStorage<VetId, Vet>) : FetchAllVetsPort {
        override fun invoke(request: FetchAllVetsRequest): FetchAllVetsResponse {
            val (vets, count) = storage.findAll(request.paginationInfo)
            return FetchAllVetsResponse(vets, count)
        }
    }

    class RemoveVetAdapter(private val storage: InMemoryStorage<VetId, Vet>) : RemoveVetPort {
        override fun invoke(request: RemoveVetRequest): RemoveVetResponse {
            storage.delete(request.id)
            return RemoveVetResponse()
        }
    }

    fun saveVetPort(): SaveVetPort = SaveVetAdapter(storage)
    fun fetchVetPort(): FetchVetPort = FetchVetAdapter(storage)
    fun fetchAllVetsPort(): FetchAllVetsPort = FetchAllVetsAdapter(storage)
    fun removeVetPort(): RemoveVetPort = RemoveVetAdapter(storage)
}
