package ru.govnocode.kotlinmusicplayer.domain.entities

data class Song(
    val id: Long,
    val title: String,
    val artistName: String,
    val albumName: String,
    val duration: Int,
)
