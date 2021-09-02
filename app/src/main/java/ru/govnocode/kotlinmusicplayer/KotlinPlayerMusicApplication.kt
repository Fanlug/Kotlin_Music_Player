package ru.govnocode.kotlinmusicplayer

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.govnocode.kotlinmusicplayer.di.networkModule

class KotlinPlayerMusicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KotlinPlayerMusicApplication)
            modules(listOf(networkModule))
        }
    }

}