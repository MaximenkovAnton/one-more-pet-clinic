package com.simarel.onemorepetclinic.application.usecase.vet.create

import com.simarel.onemorepetclinic.application.stub.SaveVetPortStub
import com.simarel.onemorepetclinic.port.input.vet.CreateVetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreateVetUseCaseTest {

    private lateinit var saveVetPortStub: SaveVetPortStub
    private lateinit var createVetUseCase: CreateVetUseCase

    @BeforeEach
    fun setUp() {
        saveVetPortStub = SaveVetPortStub()
        createVetUseCase = CreateVetUseCase(saveVetPortStub)
    }

    @Test
    fun `should save vet and return it in response`() {
        // Arrange
        val vet = DomainObjectFactory.createVet()
        val request = CreateVetRequest(vet)

        // Act
        val response = createVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(vet, response.vet)
        assertEquals(vet, saveVetPortStub.getLastSavedVet())
    }
}
