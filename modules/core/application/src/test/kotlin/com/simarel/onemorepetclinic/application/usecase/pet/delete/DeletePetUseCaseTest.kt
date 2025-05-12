package com.simarel.onemorepetclinic.application.usecase.pet.delete

import com.simarel.onemorepetclinic.application.stub.RemovePetPortStub
import com.simarel.onemorepetclinic.port.input.pet.DeletePetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeletePetUseCaseTest {

    private lateinit var removePetPortStub: RemovePetPortStub
    private lateinit var deletePetUseCase: DeletePetUseCase

    @BeforeEach
    fun setUp() {
        removePetPortStub = RemovePetPortStub()
        deletePetUseCase = DeletePetUseCase(removePetPortStub)
    }

    @Test
    fun `should remove pet by id`() {
        // Arrange
        val petId = IdFactory.createPetId()
        val request = DeletePetRequest(petId)

        // Act
        val response = deletePetUseCase.invoke(request)

        // Assert
        assertEquals(petId, removePetPortStub.getLastRemovedPetId())
        assertTrue(removePetPortStub.wasPetRemoved(petId))
    }
}
