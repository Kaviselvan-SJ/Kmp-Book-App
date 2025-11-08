package org.example.kmpbookapp.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.example.kmpbookapp.book.data.database.DatabaseFactory
import org.koin.dsl.module

actual val platformModule: org.koin.core.module.Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        single { DatabaseFactory() }
    }