package com.simarel.onemorepetclinic.application.usecase.owner.read

import com.simarel.onemorepetclinic.application.stub.FetchOwnerPortStub
import com.simarel.onemorepetclinic.domain.exception.OwnerNotFoundException
import com.simarel.onemorepetclinic.port.input.owner.ReadOwnerRequest
import com.simarel.onemorepetclinic.test.utils.domain.factory.IdFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadOwnerUseCaseTest {

    private lateinit var fetchOwnerPortStub: FetchOwnerPortStub
    private lateinit var readOwnerUseCase: ReadOwnerUseCase

    @BeforeEach
    fun setUp() {
        fetchOwnerPortStub = FetchOwnerPortStub()
        readOwnerUseCase = ReadOwnerUseCase(fetchOwnerPortStub)
    }

    @Test
    fun `should return owner when owner exists`() {
        // Arrange
        val owner = fetchOwnerPortStub.getOwners().values.first()
        val request = ReadOwnerRequest(owner.id)

        // Act
        val response = readOwnerUseCase.invoke(request)

        // Assert
        assertNotNull(response)
        assertEquals(owner, response.owner)
    }

    @Test
    fun `should throw OwnerNotFoundException when owner does not exist`() {
        // Arrange
        val nonExistentOwnerId = IdFactory.createOwnerId()
        val request = ReadOwnerRequest(nonExistentOwnerId)

        // Act & Assert
        assertThrows<OwnerNotFoundException> {
            readOwnerUseCase.invoke(request)
        }
    }
}
