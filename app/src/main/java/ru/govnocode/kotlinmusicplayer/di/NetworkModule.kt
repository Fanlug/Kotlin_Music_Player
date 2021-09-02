package ru.govnocode.kotlinmusicplayer.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.govnocode.kotlinmusicplayer.data.api.VkMusicApi
import ru.govnocode.kotlinmusicplayer.util.HeaderInterceptor

val networkModule = module {

    factory { provideVkApi(get()) }
    factory { provideLoggingInterceptor() }
    single { provideRetrofit(get()) }
    factory { provideHttpClient(get(), get()) }
    factory { HeaderInterceptor() }

}

private fun provideVkApi(retrofit: Retrofit): VkMusicApi {
    return retrofit.create(VkMusicApi::class.java)
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.vk.com/method/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

private fun provideHttpClient(
    headerInterceptor: HeaderInterceptor,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BASIC
    return logger
}

