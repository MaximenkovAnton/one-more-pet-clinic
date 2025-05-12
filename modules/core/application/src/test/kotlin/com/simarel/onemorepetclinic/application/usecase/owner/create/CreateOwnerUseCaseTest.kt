package com.simarel.onemorepetclinic.application.usecase.owner.create

import com.simarel.onemorepetclinic.application.stub.SaveOwnerPortStub
import com.simarel.onemorepetclinic.port.input.owner.CreateOwnerRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreateOwnerUseCaseTest {

    private lateinit var saveOwnerPortStub: SaveOwnerPortStub
    private lateinit var createOwnerUseCase: CreateOwnerUseCase

    @BeforeEach
    fun setUp() {
        saveOwnerPortStub = SaveOwnerPortStub()
        createOwnerUseCase = CreateOwnerUseCase(saveOwnerPortStub)
    }

    @Test
    fun `should save owner and return it in response`() {
        // Arrange
        val owner = DomainObjectFactory.createOwner()
        val request = CreateOwnerRequest(owner)

        // Act
        val response = createOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(owner, response.owner)
        assertEquals(owner, saveOwnerPortStub.getLastSavedOwner())
    }
}
