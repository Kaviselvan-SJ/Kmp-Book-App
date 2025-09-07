package org.example.kmpbookapp.book.presentation.book_list

import org.example.kmpbookapp.book.domain.Book
import org.example.kmpbookapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading:Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText
)
