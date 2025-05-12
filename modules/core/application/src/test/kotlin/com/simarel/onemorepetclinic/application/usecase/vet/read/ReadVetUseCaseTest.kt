package com.simarel.onemorepetclinic.application.usecase.vet.read

import com.simarel.onemorepetclinic.application.stub.FetchVetPortStub
import com.simarel.onemorepetclinic.domain.exception.VetNotFoundException
import com.simarel.onemorepetclinic.port.input.vet.ReadVetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadVetUseCaseTest {

    private lateinit var fetchVetPortStub: FetchVetPortStub
    private lateinit var readVetUseCase: ReadVetUseCase

    @BeforeEach
    fun setUp() {
        fetchVetPortStub = FetchVetPortStub()
        readVetUseCase = ReadVetUseCase(fetchVetPortStub)
    }

    @Test
    fun `should return vet when vet exists`() {
        // Arrange
        val vet = fetchVetPortStub.getVets().values.first()
        val request = ReadVetRequest(vet.id)

        // Act
        val response = readVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(vet, response.vet)
    }

    @Test
    fun `should throw VetNotFoundException when vet does not exist`() {
        // Arrange
        val nonExistentVetId = IdFactory.createVetId()
        val request = ReadVetRequest(nonExistentVetId)

        // Act & Assert
        assertThrows<VetNotFoundException> {
            readVetUseCase.invoke(request)
        }
    }
}
