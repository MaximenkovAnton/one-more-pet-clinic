package com.simarel.onemorepetclinic.application.usecase.pet.read

import com.simarel.onemorepetclinic.application.stub.FetchPetPortStub
import com.simarel.onemorepetclinic.domain.exception.PetNotFoundException
import com.simarel.onemorepetclinic.port.input.pet.ReadPetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadPetUseCaseTest {

    private lateinit var fetchPetPortStub: FetchPetPortStub
    private lateinit var readPetUseCase: ReadPetUseCase

    @BeforeEach
    fun setUp() {
        fetchPetPortStub = FetchPetPortStub()
        readPetUseCase = ReadPetUseCase(fetchPetPortStub)
    }

    @Test
    fun `should return pet when pet exists`() {
        // Arrange
        val pet = fetchPetPortStub.getPets().values.first()
        val request = ReadPetRequest(pet.id)

        // Act
        val response = readPetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(pet, response.pet)
    }

    @Test
    fun `should throw PetNotFoundException when pet does not exist`() {
        // Arrange
        val nonExistentPetId = IdFactory.createPetId()
        val request = ReadPetRequest(nonExistentPetId)

        // Act & Assert
        assertThrows<PetNotFoundException> {
            readPetUseCase.invoke(request)
        }
    }
}
