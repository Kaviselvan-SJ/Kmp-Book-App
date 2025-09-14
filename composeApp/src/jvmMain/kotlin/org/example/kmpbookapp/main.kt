package org.example.kmpbookapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.kmpbookapp.app.App
import org.example.kmpbookapp.di.initKoin

fun main()  {
    initKoin ()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookApp",
        ) {
            App()
        }
    }
}