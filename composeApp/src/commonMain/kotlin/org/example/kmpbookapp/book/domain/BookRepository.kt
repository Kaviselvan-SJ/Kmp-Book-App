package org.example.kmpbookapp.book.domain

import kotlinx.coroutines.flow.Flow
import org.example.kmpbookapp.book.data.database.BookEntity
import org.example.kmpbookapp.core.domain.DataError
import org.example.kmpbookapp.core.domain.EmptyResult
import org.example.kmpbookapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String) : Result<String?, DataError>

    suspend fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)

}