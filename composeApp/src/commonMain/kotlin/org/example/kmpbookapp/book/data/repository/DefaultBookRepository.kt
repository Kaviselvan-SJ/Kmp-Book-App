package org.example.kmpbookapp.book.data.repository

import org.example.kmpbookapp.book.data.mappers.toBook
import org.example.kmpbookapp.book.data.network.KtorRemoteBookDataSource
import org.example.kmpbookapp.book.domain.Book
import org.example.kmpbookapp.book.domain.BookRepository
import org.example.kmpbookapp.core.domain.DataError
import org.example.kmpbookapp.core.domain.Result
import org.example.kmpbookapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: KtorRemoteBookDataSource
): BookRepository {

    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map{it.toBook()}
            }
    }


}