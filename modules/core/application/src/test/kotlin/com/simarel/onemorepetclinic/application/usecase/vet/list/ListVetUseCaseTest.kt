package com.simarel.onemorepetclinic.application.usecase.vet.list

import com.simarel.onemorepetclinic.application.stub.FetchAllVetsPortStub
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageNumber
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageSize
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PaginationInfo
import com.simarel.onemorepetclinic.port.input.vet.ListVetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ListVetUseCaseTest {

    private lateinit var fetchAllVetsPortStub: FetchAllVetsPortStub
    private lateinit var listVetUseCase: ListVetUseCase

    @BeforeEach
    fun setUp() {
        fetchAllVetsPortStub = FetchAllVetsPortStub()
        listVetUseCase = ListVetUseCase(fetchAllVetsPortStub)
    }

    @Test
    fun `should return all vets when no speciality is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)
        val request = ListVetRequest(paginationInfo, null)

        // Act
        val response = listVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(5, response.vets.size) // Всего 5 ветеринаров в стабе
        assertEquals(5, response.count.value)
        assertEquals(paginationInfo, fetchAllVetsPortStub.getLastPaginationInfo())
        assertEquals(null, fetchAllVetsPortStub.getLastSpeciality())
    }

    @Test
    fun `should return vets with specific speciality when speciality is provided`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Берем специальность, которая точно есть у некоторых ветеринаров
        val speciality = ValueObjectFactory.createSpeciality("Хирургия")
        val request = ListVetRequest(paginationInfo, speciality)

        // Act
        val response = listVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        val expectedVetCount = fetchAllVetsPortStub.getVetsBySpeciality(speciality).size
        assertEquals(expectedVetCount, response.vets.size)
        assertEquals(expectedVetCount.toLong(), response.count.value)
        assertEquals(paginationInfo, fetchAllVetsPortStub.getLastPaginationInfo())
        assertEquals(speciality, fetchAllVetsPortStub.getLastSpeciality())
    }

    @Test
    fun `should return empty list when no vets have the specified speciality`() {
        // Arrange
        val pageNumber = PageNumber.of(0)
        val pageSize = PageSize.of(10)
        val paginationInfo = PaginationInfo(pageNumber, pageSize)

        // Создаем специальность, которой нет ни у одного ветеринара
        val nonExistentSpeciality = ValueObjectFactory.createSpeciality("Несуществующая специальность")
        val request = ListVetRequest(paginationInfo, nonExistentSpeciality)

        // Act
        val response = listVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(0, response.vets.size)
        assertEquals(0, response.count.value)
        assertEquals(paginationInfo, fetchAllVetsPortStub.getLastPaginationInfo())
        assertEquals(nonExistentSpeciality, fetchAllVetsPortStub.getLastSpeciality())
    }
}
