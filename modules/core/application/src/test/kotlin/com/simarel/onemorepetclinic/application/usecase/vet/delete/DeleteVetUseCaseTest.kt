package com.simarel.onemorepetclinic.application.usecase.vet.delete

import com.simarel.onemorepetclinic.application.stub.RemoveVetPortStub
import com.simarel.onemorepetclinic.port.input.vet.DeleteVetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeleteVetUseCaseTest {

    private lateinit var removeVetPortStub: RemoveVetPortStub
    private lateinit var deleteVetUseCase: DeleteVetUseCase

    @BeforeEach
    fun setUp() {
        removeVetPortStub = RemoveVetPortStub()
        deleteVetUseCase = DeleteVetUseCase(removeVetPortStub)
    }

    @Test
    fun `should remove vet by id`() {
        // Arrange
        val vetId = IdFactory.createVetId()
        val request = DeleteVetRequest(vetId)

        // Act
        val response = deleteVetUseCase.invoke(request)

        // Assert
        assertEquals(vetId, removeVetPortStub.getLastRemovedVetId())
        assertTrue(removeVetPortStub.wasVetRemoved(vetId))
    }
}
