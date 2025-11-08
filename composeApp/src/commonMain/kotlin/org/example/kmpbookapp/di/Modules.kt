package org.example.kmpbookapp.di

import androidx.sqlite.SQLiteDriver
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.example.kmpbookapp.book.data.database.DatabaseFactory
import org.example.kmpbookapp.book.data.database.FavoriteBookDatabase
import org.example.kmpbookapp.book.data.network.KtorRemoteBookDataSource
import org.example.kmpbookapp.book.data.network.RemoteBookDataSource
import org.example.kmpbookapp.book.data.repository.DefaultBookRepository
import org.example.kmpbookapp.book.domain.BookRepository
import org.example.kmpbookapp.book.presentation.SelectedBookViewModel
import org.example.kmpbookapp.book.presentation.book_detail.BookDetailViewModel
import org.example.kmpbookapp.book.presentation.book_list.BookListViewModel
import org.example.kmpbookapp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)

}