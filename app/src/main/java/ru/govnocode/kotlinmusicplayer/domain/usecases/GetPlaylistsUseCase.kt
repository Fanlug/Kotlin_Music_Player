package ru.govnocode.kotlinmusicplayer.domain.usecases

import ru.govnocode.kotlinmusicplayer.domain.entities.Playlist
import ru.govnocode.kotlinmusicplayer.domain.repositories.PlaylistRepository

class GetPlaylistsUseCase(private val playlistRepository: PlaylistRepository) {

    operator fun invoke(): List<Playlist> {
        return playlistRepository.getAll()
    }

}