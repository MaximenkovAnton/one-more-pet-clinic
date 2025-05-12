package com.simarel.onemorepetclinic.application.usecase.visit.read

import com.simarel.onemorepetclinic.application.stub.FetchVisitPortStub
import com.simarel.onemorepetclinic.domain.exception.VisitNotFoundException
import com.simarel.onemorepetclinic.port.input.visit.ReadVisitRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadVisitUseCaseTest {

    private lateinit var fetchVisitPortStub: FetchVisitPortStub
    private lateinit var readVisitUseCase: ReadVisitUseCase

    @BeforeEach
    fun setUp() {
        fetchVisitPortStub = FetchVisitPortStub()
        readVisitUseCase = ReadVisitUseCase(fetchVisitPortStub)
    }

    @Test
    fun `should return visit when visit exists`() {
        // Arrange
        val visit = fetchVisitPortStub.getVisits().values.first()
        val request = ReadVisitRequest(visit.id)

        // Act
        val response = readVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(visit, response.visit)
    }

    @Test
    fun `should throw VisitNotFoundException when visit does not exist`() {
        // Arrange
        val nonExistentVisitId = IdFactory.createVisitId()
        val request = ReadVisitRequest(nonExistentVisitId)

        // Act & Assert
        assertThrows<VisitNotFoundException> {
            readVisitUseCase.invoke(request)
        }
    }
}
