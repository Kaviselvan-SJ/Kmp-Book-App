package org.example.kmpbookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform