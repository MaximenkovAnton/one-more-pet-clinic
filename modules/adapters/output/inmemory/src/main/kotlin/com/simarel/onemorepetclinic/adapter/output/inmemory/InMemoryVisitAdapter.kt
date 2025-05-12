package com.simarel.onemorepetclinic.adapter.output.inmemory

import com.simarel.onemorepetclinic.domain.Visit
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsPort
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsRequest
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsResponse
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitPort
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitResponse
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitRequest
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitResponse

class InMemoryVisitAdapter {
    private val storage = InMemoryStorage<VisitId, Visit>()

    class SaveVisitAdapter(private val storage: InMemoryStorage<VisitId, Visit>) : SaveVisitPort {
        override fun invoke(request: SaveVisitRequest): SaveVisitResponse {
            val savedVisit = storage.save(request.visit.id, request.visit)
            return SaveVisitResponse(savedVisit)
        }
    }

    class FetchVisitAdapter(private val storage: InMemoryStorage<VisitId, Visit>) : FetchVisitPort {
        override fun invoke(request: FetchVisitRequest): FetchVisitResponse {
            val visit = storage.findById(request.id)
            return FetchVisitResponse(visit)
        }
    }

    class FetchAllVisitsAdapter(private val storage: InMemoryStorage<VisitId, Visit>) : FetchAllVisitsPort {
        override fun invoke(request: FetchAllVisitsRequest): FetchAllVisitsResponse {
            val (visits, count) = storage.findAll(request.paginationInfo)
            return FetchAllVisitsResponse(visits, count)
        }
    }

    class RemoveVisitAdapter(private val storage: InMemoryStorage<VisitId, Visit>) : RemoveVisitPort {
        override fun invoke(request: RemoveVisitRequest): RemoveVisitResponse {
            storage.delete(request.id)
            return RemoveVisitResponse()
        }
    }

    fun saveVisitPort(): SaveVisitPort = SaveVisitAdapter(storage)
    fun fetchVisitPort(): FetchVisitPort = FetchVisitAdapter(storage)
    fun fetchAllVisitsPort(): FetchAllVisitsPort = FetchAllVisitsAdapter(storage)
    fun removeVisitPort(): RemoveVisitPort = RemoveVisitAdapter(storage)
}
