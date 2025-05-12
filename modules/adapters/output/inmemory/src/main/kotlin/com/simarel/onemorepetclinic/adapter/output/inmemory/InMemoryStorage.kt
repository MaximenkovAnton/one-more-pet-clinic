package com.simarel.onemorepetclinic.adapter.output.inmemory

import com.simarel.onemorepetclinic.domain.valueobject.Count
import com.simarel.onemorepetclinic.domain.valueobject.id.EntityId
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import java.util.concurrent.ConcurrentHashMap

class InMemoryStorage<ID : EntityId, T : Any> {
    private val storage = ConcurrentHashMap<ID, T>()

    fun save(id: ID, entity: T): T {
        storage[id] = entity
        return entity
    }

    fun findById(id: ID): T? {
        return storage[id]
    }

    fun findAll(paginationInfo: PaginationInfo): Pair<List<T>, Count> {
        val allEntities = storage.values.toList()
        val startIndex = paginationInfo.pageNumber.value * paginationInfo.pageSize.value
        val endIndex = minOf(startIndex + paginationInfo.pageSize.value, allEntities.size)
        
        val paginatedEntities = if (startIndex < allEntities.size) {
            allEntities.subList(startIndex, endIndex)
        } else {
            emptyList()
        }
        
        return Pair(paginatedEntities, Count.of(allEntities.size.toLong()))
    }

    fun delete(id: ID) {
        storage.remove(id)
    }

    fun clear() {
        storage.clear()
    }
}
