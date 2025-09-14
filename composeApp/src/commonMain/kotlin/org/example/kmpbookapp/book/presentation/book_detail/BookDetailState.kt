package org.example.kmpbookapp.book.presentation.book_detail

import org.example.kmpbookapp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavourite: Boolean = false,
    val book: Book? = null,

    )
