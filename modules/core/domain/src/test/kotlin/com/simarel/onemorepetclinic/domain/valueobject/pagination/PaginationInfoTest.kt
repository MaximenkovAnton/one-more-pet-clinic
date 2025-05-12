package com.simarel.onemorepetclinic.domain.valueobject.pagination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PaginationInfoTest {

    @Test
    fun `should create PaginationInfo with valid values`() {
        // Arrange
        val pageNumber = 2
        val pageSize = 20

        // Act
        val paginationInfo = PaginationInfo.of(pageNumber, pageSize)

        // Assert
        assertEquals(pageNumber, paginationInfo.pageNumber.value)
        assertEquals(pageSize, paginationInfo.pageSize.value)
    }

    @Test
    fun `should throw NegativePageNumberValidationException when pageNumber is negative`() {
        // Arrange
        val negativePageNumber = -1
        val validPageSize = 20

        // Act & Assert
        assertThrows<NegativePageNumberValidationException> { PaginationInfo.of(negativePageNumber, validPageSize) }
    }

    @Test
    fun `should throw NegativePageSizeValidationException when pageSize is zero or negative`() {
        // Arrange
        val validPageNumber = 1
        val zeroPageSize = 0

        // Act & Assert
        assertThrows<NegativePageSizeValidationException> { PaginationInfo.of(validPageNumber, zeroPageSize) }
    }

    @Test
    fun `should throw TooBigPageSizeValidationException when pageSize is greater than max allowed`() {
        // Arrange
        val validPageNumber = 1
        val tooBigPageSize = 101 // Assuming MAX_PAGE_SIZE is 100

        // Act & Assert
        assertThrows<TooBigPageSizeValidationException> { PaginationInfo.of(validPageNumber, tooBigPageSize) }
    }
}
