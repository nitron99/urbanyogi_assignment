package com.example.urbanyogi_assignment

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.urbanyogi_assignment.ui.theme.UrbanYogi_assignmentTheme

class MusicActivity : ComponentActivity() {

    private var index : Int = 0

    var gotlink : Boolean = false
    lateinit var mediaPlayer: MediaPlayer

    val text = mutableStateOf("play")
    val progress = mutableStateOf(0.1f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbanYogi_assignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Music_screen()
                }
            }
        }

        val intent = intent
        index = intent.getIntExtra("song", 0)

        Log.d("TAG", index.toString())

    }

    fun getLink() : String{
        val linklist = arrayOf<String>("https://cdn.urbanyogi.app/audio%2FBright%20Moon%20(2Hz%20Binaural%20Beats).mp3"
            ,"https://cdn.urbanyogi.app/audio%2FCosmic%20Love.mp3"
            ,"https://cdn.urbanyogi.app/audio/10%20min%20Stress%20relief%20vocals%20only.mp3"
            ,"https://cdn.urbanyogi.app/audio%2F540%20Relax%20Before%20a%20Good%20Night%20Sleep%20-%205%20Min.mp3"
            ,"https://cdn.urbanyogi.app/audio/Purple%20Light.mp3")

        return linklist[index]
    }

    fun play() {

        if(!gotlink)
        {
            val url: String = getLink()

            mediaPlayer = MediaPlayer.create(
                this,
                Uri.parse(url)
            )
            gotlink = true

        }
        if(!mediaPlayer.isPlaying) {
            text.value = "Pause"
            progress.value = 0.0f
            mediaPlayer.start()
        } else{
            mediaPlayer.pause()
            text.value = "Play"
        }

    }

    @Composable
    fun Music_screen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            Color.Black
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Button(
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    ,

                onClick = { play() }
            ) {

                val t by text
                Text(text = t)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        UrbanYogi_assignmentTheme {
            Music_screen()
        }
    }
}