package ru.govnocode.kotlinmusicplayer.domain.repositories

interface BaseRepository<T> {

    fun getAll(): List<T>

    fun getById(id: Long): T

    fun deleteById(id: Long)

}