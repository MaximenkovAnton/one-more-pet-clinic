package com.simarel.onemorepetclinic.adapter.output.inmemory

import com.simarel.onemorepetclinic.domain.Owner
import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersPort
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersRequest
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersResponse
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerResponse
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerRequest
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerResponse

class InMemoryOwnerAdapter {
    private val storage = InMemoryStorage<OwnerId, Owner>()

    class SaveOwnerAdapter(private val storage: InMemoryStorage<OwnerId, Owner>) : SaveOwnerPort {
        override fun invoke(request: SaveOwnerRequest): SaveOwnerResponse {
            val savedOwner = storage.save(request.owner.id, request.owner)
            return SaveOwnerResponse(savedOwner)
        }
    }

    class FetchOwnerAdapter(private val storage: InMemoryStorage<OwnerId, Owner>) : FetchOwnerPort {
        override fun invoke(request: FetchOwnerRequest): FetchOwnerResponse {
            val owner = storage.findById(request.id)
            return FetchOwnerResponse(owner)
        }
    }

    class FetchAllOwnersAdapter(private val storage: InMemoryStorage<OwnerId, Owner>) : FetchAllOwnersPort {
        override fun invoke(request: FetchAllOwnersRequest): FetchAllOwnersResponse {
            val (owners, count) = storage.findAll(request.paginationInfo)
            return FetchAllOwnersResponse(owners, count)
        }
    }

    class RemoveOwnerAdapter(private val storage: InMemoryStorage<OwnerId, Owner>) : RemoveOwnerPort {
        override fun invoke(request: RemoveOwnerRequest): RemoveOwnerResponse {
            storage.delete(request.id)
            return RemoveOwnerResponse()
        }
    }

    fun saveOwnerPort(): SaveOwnerPort = SaveOwnerAdapter(storage)
    fun fetchOwnerPort(): FetchOwnerPort = FetchOwnerAdapter(storage)
    fun fetchAllOwnersPort(): FetchAllOwnersPort = FetchAllOwnersAdapter(storage)
    fun removeOwnerPort(): RemoveOwnerPort = RemoveOwnerAdapter(storage)
}
