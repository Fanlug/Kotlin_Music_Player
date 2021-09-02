package ru.govnocode.kotlinmusicplayer.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface VkMusicApi {

    @GET("audio.get")
    suspend fun getAudio(
        @Query("owner_id") ownerId: Int? = null,
        @Query("album_id") albumId: Int? = null,
        @Query("count") count: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("access_token") accessToken: String = "8b24988e3e061426298b3664d75d6f61a03b5e8ec65a2f7d7c9cc88f37bd1e0cc8c3a5d4020768778516b",
        @Query("v") version: Double = 5.95
    ): VkAudioGetResponse
}