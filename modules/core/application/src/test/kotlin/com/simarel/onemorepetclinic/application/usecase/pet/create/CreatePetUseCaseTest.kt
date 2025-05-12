package com.simarel.onemorepetclinic.application.usecase.pet.create

import com.simarel.onemorepetclinic.application.stub.SavePetPortStub
import com.simarel.onemorepetclinic.port.input.pet.CreatePetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreatePetUseCaseTest {

    private lateinit var savePetPortStub: SavePetPortStub
    private lateinit var createPetUseCase: CreatePetUseCase

    @BeforeEach
    fun setUp() {
        savePetPortStub = SavePetPortStub()
        createPetUseCase = CreatePetUseCase(savePetPortStub)
    }

    @Test
    fun `should save pet and return it in response`() {
        // Arrange
        val pet = DomainObjectFactory.createPet()
        val request = CreatePetRequest(pet)

        // Act
        val response = createPetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(pet, response.pet)
        assertEquals(pet, savePetPortStub.getLastSavedPet())
    }
}
