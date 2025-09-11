package org.example.kmpbookapp.book.presentation.book_list

import org.example.kmpbookapp.book.domain.Book
import org.example.kmpbookapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading:Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)


val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "",
        authors = listOf("Author $it"),
        description = "Description $it",
        languages = listOf("Language $it"),
        firstPublishYear = "2000",
        averageRating = 4.554645,
        numPages = 55,
        numEditions = 10,
        ratingCount = 100
    )
}