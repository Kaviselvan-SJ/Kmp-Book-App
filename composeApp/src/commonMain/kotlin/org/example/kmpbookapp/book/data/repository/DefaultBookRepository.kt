package org.example.kmpbookapp.book.data.repository

import bookapp.composeapp.generated.resources.Res
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.kmpbookapp.book.data.database.FavoriteBookDao
import org.example.kmpbookapp.book.data.mappers.toBook
import org.example.kmpbookapp.book.data.mappers.toBookEntity
import org.example.kmpbookapp.book.data.network.KtorRemoteBookDataSource
import org.example.kmpbookapp.book.domain.Book
import org.example.kmpbookapp.book.domain.BookRepository
import org.example.kmpbookapp.core.domain.DataError
import org.example.kmpbookapp.core.domain.EmptyResult
import org.example.kmpbookapp.core.domain.Result
import org.example.kmpbookapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: KtorRemoteBookDataSource,
    private val FavoriteBookDao : FavoriteBookDao
): BookRepository {

    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map{it.toBook()}
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = FavoriteBookDao.getFavoriteBook(bookId)
        return if(localResult == null){
            remoteBookDataSource
                .getBookDetail(bookId)
                .map {it.description}
        } else {
            Result.Success(localResult.description)
        }
    }

    override suspend fun getFavoriteBooks(): Flow<List<Book>> {
        return FavoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return FavoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any{it.id == id}
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try{
            FavoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: Exception){
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        FavoriteBookDao.deleteFavoriteBook(id)
    }


}