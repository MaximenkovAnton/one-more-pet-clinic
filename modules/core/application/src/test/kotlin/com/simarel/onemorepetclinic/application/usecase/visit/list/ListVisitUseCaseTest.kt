package com.simarel.onemorepetclinic.application.usecase.visit.list

import com.simarel.onemorepetclinic.application.stub.FetchAllVisitsPortStub
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageNumber
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageSize
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.visit.ListVisitRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ListVisitUseCaseTest {

    private lateinit var fetchAllVisitsPortStub: FetchAllVisitsPortStub
    private lateinit var listVisitUseCase: ListVisitUseCase

    @BeforeEach
    fun setUp() {
        fetchAllVisitsPortStub = FetchAllVisitsPortStub()
        listVisitUseCase = ListVisitUseCase(fetchAllVisitsPortStub)
    }

    @Test
    fun `should return all visits when no pet id is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListVisitRequest(paginationInfo, null)

        // Act
        val response = listVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(5, response.visits.size) // Всего 5 визитов в стабе
        assertEquals(5, response.count.value)
        assertEquals(paginationInfo, fetchAllVisitsPortStub.getLastPaginationInfo())
        assertEquals(null, fetchAllVisitsPortStub.getLastPetId())
    }

    @Test
    fun `should return visits for specific pet when pet id is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Получаем первого питомца из стаба
        val petId = fetchAllVisitsPortStub.getVisits().values.first().pet.id
        val request = ListVisitRequest(paginationInfo, petId)

        // Act
        val response = listVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        val expectedVisitCount = fetchAllVisitsPortStub.getVisitsByPet(petId).size
        assertEquals(expectedVisitCount, response.visits.size)
        assertEquals(expectedVisitCount.toLong(), response.count.value)
        assertEquals(paginationInfo, fetchAllVisitsPortStub.getLastPaginationInfo())
        assertEquals(petId, fetchAllVisitsPortStub.getLastPetId())
    }

    @Test
    fun `should return empty list when pet has no visits`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Создаем ID питомца, которого нет в стабе
        val nonExistentPetId = IdFactory.createPetId()
        val request = ListVisitRequest(paginationInfo, nonExistentPetId)

        // Act
        val response = listVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(0, response.visits.size)
        assertEquals(0, response.count.value)
        assertEquals(paginationInfo, fetchAllVisitsPortStub.getLastPaginationInfo())
        assertEquals(nonExistentPetId, fetchAllVisitsPortStub.getLastPetId())
    }
}
