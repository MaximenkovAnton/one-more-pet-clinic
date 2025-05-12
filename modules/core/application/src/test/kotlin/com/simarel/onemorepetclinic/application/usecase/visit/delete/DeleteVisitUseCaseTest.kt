package com.simarel.onemorepetclinic.application.usecase.visit.delete

import com.simarel.onemorepetclinic.application.stub.RemoveVisitPortStub
import com.simarel.onemorepetclinic.port.input.visit.DeleteVisitRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeleteVisitUseCaseTest {

    private lateinit var removeVisitPortStub: RemoveVisitPortStub
    private lateinit var deleteVisitUseCase: DeleteVisitUseCase

    @BeforeEach
    fun setUp() {
        removeVisitPortStub = RemoveVisitPortStub()
        deleteVisitUseCase = DeleteVisitUseCase(removeVisitPortStub)
    }

    @Test
    fun `should remove visit by id`() {
        // Arrange
        val visitId = IdFactory.createVisitId()
        val request = DeleteVisitRequest(visitId)

        // Act
        val response = deleteVisitUseCase.invoke(request)

        // Assert
        assertEquals(visitId, removeVisitPortStub.getLastRemovedVisitId())
        assertTrue(removeVisitPortStub.wasVisitRemoved(visitId))
    }
}
