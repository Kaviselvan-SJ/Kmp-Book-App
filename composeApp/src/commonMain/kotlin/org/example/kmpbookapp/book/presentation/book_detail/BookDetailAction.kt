package org.example.kmpbookapp.book.presentation.book_detail

import org.example.kmpbookapp.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavouriteClick: BookDetailAction
    data class OnSelectedBookChange(val book : Book): BookDetailAction
}