package ru.govnocode.kotlinmusicplayer.presenation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.govnocode.kotlinmusicplayer.R
import ru.govnocode.kotlinmusicplayer.data.api.VkMusicApi

class MainActivity : AppCompatActivity() {

    private val vkApi: VkMusicApi by inject()
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("Activity", vkApi.getAudio().response.items.toString())
        }
    }
}