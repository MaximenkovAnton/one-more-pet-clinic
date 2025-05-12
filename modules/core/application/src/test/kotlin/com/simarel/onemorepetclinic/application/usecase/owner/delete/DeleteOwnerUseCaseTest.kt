package com.simarel.onemorepetclinic.application.usecase.owner.delete

import com.simarel.onemorepetclinic.application.stub.RemoveOwnerPortStub
import com.simarel.onemorepetclinic.port.input.owner.DeleteOwnerRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeleteOwnerUseCaseTest {

    private lateinit var removeOwnerPortStub: RemoveOwnerPortStub
    private lateinit var deleteOwnerUseCase: DeleteOwnerUseCase

    @BeforeEach
    fun setUp() {
        removeOwnerPortStub = RemoveOwnerPortStub()
        deleteOwnerUseCase = DeleteOwnerUseCase(removeOwnerPortStub)
    }

    @Test
    fun `should remove owner by id`() {
        // Arrange
        val ownerId = IdFactory.createOwnerId()
        val request = DeleteOwnerRequest(ownerId)

        // Act
        val response = deleteOwnerUseCase.invoke(request)

        // Assert
        assertEquals(ownerId, removeOwnerPortStub.getLastRemovedOwnerId())
        assertTrue(removeOwnerPortStub.wasOwnerRemoved(ownerId))
    }
}
