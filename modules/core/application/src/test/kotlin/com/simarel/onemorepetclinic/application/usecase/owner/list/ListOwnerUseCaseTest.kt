package com.simarel.onemorepetclinic.application.usecase.owner.list

import com.simarel.onemorepetclinic.application.stub.FetchAllOwnersPortStub
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageNumber
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageSize
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.owner.ListOwnerRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ListOwnerUseCaseTest {

    private lateinit var fetchAllOwnersPortStub: FetchAllOwnersPortStub
    private lateinit var listOwnerUseCase: ListOwnerUseCase

    @BeforeEach
    fun setUp() {
        fetchAllOwnersPortStub = FetchAllOwnersPortStub()
        listOwnerUseCase = ListOwnerUseCase(fetchAllOwnersPortStub)
    }

    @Test
    fun `should return owners and count for first page`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(5)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListOwnerRequest(paginationInfo)

        // Act
        val response = listOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(5, response.owners.size)
        assertEquals(10, response.count.value)
        assertEquals(paginationInfo, fetchAllOwnersPortStub.getLastPaginationInfo())
    }

    @Test
    fun `should return owners and count for second page`() {
        // Arrange
        val pageNumber = PageNumber.of(1)
        val pageSize = PageSize.of(5)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListOwnerRequest(paginationInfo)

        // Act
        val response = listOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(5, response.owners.size)
        assertEquals(10, response.count.value)
        assertEquals(paginationInfo, fetchAllOwnersPortStub.getLastPaginationInfo())
    }

    @Test
    fun `should return empty list when page is out of bounds`() {
        // Arrange
        val pageNumber = PageNumber.of(10)
        val pageSize = PageSize.of(5)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListOwnerRequest(paginationInfo)

        // Act
        val response = listOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(0, response.owners.size)
        assertEquals(10, response.count.value)
        assertEquals(paginationInfo, fetchAllOwnersPortStub.getLastPaginationInfo())
    }
}
