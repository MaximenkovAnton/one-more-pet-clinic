package com.simarel.onemorepetclinic.application.usecase.vet.update

import com.simarel.onemorepetclinic.application.stub.SaveVetPortStub
import com.simarel.onemorepetclinic.port.input.vet.UpdateVetRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.DomainObjectFactory
import com.simarel.onemorepetclinic.test.utils.domain.factory.ValueObjectFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UpdateVetUseCaseTest {

    private lateinit var saveVetPortStub: SaveVetPortStub
    private lateinit var updateVetUseCase: UpdateVetUseCase

    @BeforeEach
    fun setUp() {
        saveVetPortStub = SaveVetPortStub()
        updateVetUseCase = UpdateVetUseCase(saveVetPortStub)
    }

    @Test
    fun `should save updated vet and return it in response`() {
        // Arrange
        val originalVet = DomainObjectFactory.createVet()
        val updatedVet = DomainObjectFactory.createVet(
            id = originalVet.id,
            firstName = ValueObjectFactory.createFirstName("Новое Имя"),
            lastName = ValueObjectFactory.createLastName("Новая Фамилия"),
            specialities = setOf(ValueObjectFactory.createSpeciality("Новая Специальность"))
        )
        val request = UpdateVetRequest(updatedVet)

        // Act
        val response = updateVetUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(updatedVet, response.vet)
        assertEquals(updatedVet, saveVetPortStub.getLastSavedVet())
    }
}
