package com.simarel.onemorepetclinic.application.usecase.pet.update

import com.simarel.onemorepetclinic.application.stub.SavePetPortStub
import com.simarel.onemorepetclinic.port.input.pet.UpdatePetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UpdatePetUseCaseTest {

    private lateinit var savePetPortStub: SavePetPortStub
    private lateinit var updatePetUseCase: UpdatePetUseCase

    @BeforeEach
    fun setUp() {
        savePetPortStub = SavePetPortStub()
        updatePetUseCase = UpdatePetUseCase(savePetPortStub)
    }

    @Test
    fun `should save updated pet and return it in response`() {
        // Arrange
        val originalPet = DomainObjectFactory.createPet()
        val updatedPet = DomainObjectFactory.createPet(
            id = originalPet.id,
            name = ValueObjectFactory.createPetName("Новое Имя"),
            owner = originalPet.owner
        )
        val request = UpdatePetRequest(updatedPet)

        // Act
        val response = updatePetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(updatedPet, response.pet)
        assertEquals(updatedPet, savePetPortStub.getLastSavedPet())
    }
}
