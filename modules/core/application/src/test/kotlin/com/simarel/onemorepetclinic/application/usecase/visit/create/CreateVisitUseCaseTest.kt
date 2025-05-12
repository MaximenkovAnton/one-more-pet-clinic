package com.simarel.onemorepetclinic.application.usecase.visit.create

import com.simarel.onemorepetclinic.application.stub.SaveVisitPortStub
import com.simarel.onemorepetclinic.port.input.visit.CreateVisitRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreateVisitUseCaseTest {

    private lateinit var saveVisitPortStub: SaveVisitPortStub
    private lateinit var createVisitUseCase: CreateVisitUseCase

    @BeforeEach
    fun setUp() {
        saveVisitPortStub = SaveVisitPortStub()
        createVisitUseCase = CreateVisitUseCase(saveVisitPortStub)
    }

    @Test
    fun `should save visit and return it in response`() {
        // Arrange
        val visit = DomainObjectFactory.createVisit()
        val request = CreateVisitRequest(visit)

        // Act
        val response = createVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(visit, response.visit)
        assertEquals(visit, saveVisitPortStub.getLastSavedVisit())
    }
}
