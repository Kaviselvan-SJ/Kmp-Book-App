package org.example.kmpbookapp

import androidx.compose.ui.window.ComposeUIViewController
import org.example.kmpbookapp.app.App
import org.example.kmpbookapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }