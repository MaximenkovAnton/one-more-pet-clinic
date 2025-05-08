package com.simarel.onemorepetclinic.domain.util

import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageNumber
import com.simarel.onemorepetclinic.domain.valueobject.pagination.PageSize

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
