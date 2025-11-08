package org.example.kmpbookapp.book.data.network

import org.example.kmpbookapp.book.data.dto.BookWorkDto
import org.example.kmpbookapp.book.data.dto.SearchResponseDto
import org.example.kmpbookapp.core.domain.DataError
import org.example.kmpbookapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetail(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}