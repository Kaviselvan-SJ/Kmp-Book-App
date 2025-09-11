package org.example.kmpbookapp.book.domain

import org.example.kmpbookapp.core.domain.DataError
import org.example.kmpbookapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>

}