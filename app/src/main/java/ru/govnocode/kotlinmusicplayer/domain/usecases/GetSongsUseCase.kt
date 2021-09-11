package ru.govnocode.kotlinmusicplayer.domain.usecases

import ru.govnocode.kotlinmusicplayer.domain.entities.Song
import ru.govnocode.kotlinmusicplayer.domain.repositories.SongRepository

class GetSongsUseCase(private val songRepository: SongRepository) {

    operator fun invoke(): List<Song> {
        return songRepository.getAll()
    }

}