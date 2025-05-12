package com.simarel.onemorepetclinic.domain.valueobject.pagination

data class PaginationInfo(
    val pageNumber: PageNumber,
    val pageSize: PageSize
) {
    companion object {
        fun of(pageNumber: Int, pageSize: Int): PaginationInfo {
            return PaginationInfo(
                pageNumber = PageNumber.of(pageNumber),
                pageSize = PageSize.of(pageSize)
            )
        }
    }
}
