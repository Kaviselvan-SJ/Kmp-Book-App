package org.example.kmpbookapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource

import org.jetbrains.compose.ui.tooling.preview.Preview

import bookapp.composeapp.generated.resources.Res
import bookapp.composeapp.generated.resources.compose_multiplatform
import io.ktor.client.engine.HttpClientEngine
import org.example.kmpbookapp.book.data.network.KtorRemoteBookDataSource
import org.example.kmpbookapp.book.data.repository.DefaultBookRepository
import org.example.kmpbookapp.book.presentation.book_list.BookListScreenRoot
import org.example.kmpbookapp.book.presentation.book_list.BookListViewModel
import org.example.kmpbookapp.core.data.HttpClientFactory

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    MaterialTheme {
        BookListScreenRoot(
            viewModel = remember { BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(engine)
                    )
                )
            ) },
            onBookClick = {

            }
        )
    }
}

