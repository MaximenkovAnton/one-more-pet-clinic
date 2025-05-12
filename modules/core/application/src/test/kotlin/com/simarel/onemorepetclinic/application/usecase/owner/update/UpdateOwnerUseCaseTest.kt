package com.simarel.onemorepetclinic.application.usecase.owner.update

import com.simarel.onemorepetclinic.application.stub.SaveOwnerPortStub
import com.simarel.onemorepetclinic.port.input.owner.UpdateOwnerRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UpdateOwnerUseCaseTest {

    private lateinit var saveOwnerPortStub: SaveOwnerPortStub
    private lateinit var updateOwnerUseCase: UpdateOwnerUseCase

    @BeforeEach
    fun setUp() {
        saveOwnerPortStub = SaveOwnerPortStub()
        updateOwnerUseCase = UpdateOwnerUseCase(saveOwnerPortStub)
    }

    @Test
    fun `should save updated owner and return it in response`() {
        // Arrange
        val originalOwner = DomainObjectFactory.createOwner()
        val updatedOwner = DomainObjectFactory.createOwner(
            id = originalOwner.id,
            firstName = ValueObjectFactory.createFirstName("Новое Имя"),
            lastName = ValueObjectFactory.createLastName("Новая Фамилия"),
            address = ValueObjectFactory.createAddress("Новый Адрес")
        )
        val request = UpdateOwnerRequest(updatedOwner)

        // Act
        val response = updateOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(updatedOwner, response.owner)
        assertEquals(updatedOwner, saveOwnerPortStub.getLastSavedOwner())
    }
}
