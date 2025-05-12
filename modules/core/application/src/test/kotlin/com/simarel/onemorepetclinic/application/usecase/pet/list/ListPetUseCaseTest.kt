package com.simarel.onemorepetclinic.application.usecase.pet.list

import com.simarel.onemorepetclinic.application.stub.FetchAllPetsPortStub
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageNumber
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageSize
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.pet.ListPetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ListPetUseCaseTest {

    private lateinit var fetchAllPetsPortStub: FetchAllPetsPortStub
    private lateinit var listPetUseCase: ListPetUseCase

    @BeforeEach
    fun setUp() {
        fetchAllPetsPortStub = FetchAllPetsPortStub()
        listPetUseCase = ListPetUseCase(fetchAllPetsPortStub)
    }

    @Test
    fun `should return all pets when no owner id is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListPetRequest(paginationInfo, null)

        // Act
        val response = listPetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(5, response.pets.size) // Всего 5 питомцев в стабе
        assertEquals(5, response.count.value)
        assertEquals(paginationInfo, fetchAllPetsPortStub.getLastPaginationInfo())
        assertEquals(null, fetchAllPetsPortStub.getLastOwnerId())
    }

    @Test
    fun `should return pets for specific owner when owner id is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Получаем первого владельца из стаба
        val ownerId = fetchAllPetsPortStub.getPets().values.first().owner.id
        val request = ListPetRequest(paginationInfo, ownerId)

        // Act
        val response = listPetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        val expectedPetCount = fetchAllPetsPortStub.getPetsByOwner(ownerId).size
        assertEquals(expectedPetCount, response.pets.size)
        assertEquals(expectedPetCount.toLong(), response.count.value)
        assertEquals(paginationInfo, fetchAllPetsPortStub.getLastPaginationInfo())
        assertEquals(ownerId, fetchAllPetsPortStub.getLastOwnerId())
    }

    @Test
    fun `should return empty list when owner has no pets`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Создаем ID владельца, которого нет в стабе
        val nonExistentOwnerId = IdFactory.createOwnerId()
        val request = ListPetRequest(paginationInfo, nonExistentOwnerId)

        // Act
        val response = listPetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(0, response.pets.size)
        assertEquals(0, response.count.value)
        assertEquals(paginationInfo, fetchAllPetsPortStub.getLastPaginationInfo())
        assertEquals(nonExistentOwnerId, fetchAllPetsPortStub.getLastOwnerId())
    }
}
