package com.simarel.onemorepetclinic.application.usecase.visit.update

import com.simarel.onemorepetclinic.application.stub.SaveVisitPortStub
import com.simarel.onemorepetclinic.port.input.visit.UpdateVisitRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class UpdateVisitUseCaseTest {

    private lateinit var saveVisitPortStub: SaveVisitPortStub
    private lateinit var updateVisitUseCase: UpdateVisitUseCase

    @BeforeEach
    fun setUp() {
        saveVisitPortStub = SaveVisitPortStub()
        updateVisitUseCase = UpdateVisitUseCase(saveVisitPortStub)
    }

    @Test
    fun `should save updated visit and return it in response`() {
        // Arrange
        val originalVisit = DomainObjectFactory.createVisit()
        val updatedVisit = DomainObjectFactory.createVisit(
            id = originalVisit.id,
            date = ValueObjectFactory.createVisitDate(LocalDate.now().plusDays(10)),
            description = ValueObjectFactory.createDescription("Обновленное описание"),
            pet = originalVisit.pet
        )
        val request = UpdateVisitRequest(updatedVisit)

        // Act
        val response = updateVisitUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(updatedVisit, response.visit)
        assertEquals(updatedVisit, saveVisitPortStub.getLastSavedVisit())
    }
}
