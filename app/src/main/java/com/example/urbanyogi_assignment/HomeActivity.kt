package com.example.urbanyogi_assignment

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbanyogi_assignment.Class.Song
import com.example.urbanyogi_assignment.ui.theme.UrbanYogi_assignmentTheme
import com.example.urbanyogi_assignment.ui.theme.components.songCard
import com.example.urbanyogi_assignment.viewModel.songViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.logging.Logger.global

class HomeActivity : ComponentActivity() {

    private val viewModel by viewModels<songViewModel>()

    private lateinit var auth: FirebaseAuth
    var user: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbanYogi_assignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                        Home_screen()
                }

            }
        }
            auth = FirebaseAuth.getInstance()
            user = auth.currentUser
            //fetch()
        }

        fun fetch() {
            var songList: ArrayList<Song> = ArrayList()
            var i: Int = 0
            if (user != null) {
                val db = Firebase.firestore
                db.collection("tracks")
                    .get()
                    .addOnSuccessListener { document ->
                        for (docu in document) {
                            songList.add(Song(docu.data.get("id").toString(),
                            docu.data.get("name").toString(),
                            docu.data.get("artistName").toString(),
                            docu.data.get("artistImage").toString(),
                            docu.data.get("image").toString(),
                            docu.data.get("trackUrl").toString()))

                        Log.d("TAG", songList.get(i).name)
                        i++
                        }
                    }
                    .addOnFailureListener { e ->
                        Log.d("TAG", "get failed with ", e)
                    }
            }

        }

        override fun onBackPressed() {
            super.onBackPressed()
            auth.signOut()
        }

        override fun onDestroy() {
            super.onDestroy()
            auth.signOut()
        }

        fun gotoFavourite(){
            val intent = Intent(this, FavourActivity::class.java)
                .putExtra("song" , 1)
            startActivity(intent)
        }

        fun song1()
        {
            val intent = Intent(this, MusicActivity::class.java)
                .putExtra("song" , 1)
            startActivity(intent)

        }
        fun song2()
        {
            val intent = Intent(this, MusicActivity::class.java)
                .putExtra("song" , 2)
            startActivity(intent)

        }
        fun song3()
        {
            val intent = Intent(this, MusicActivity::class.java)
                .putExtra("song" , 3)
            startActivity(intent)

        }
        fun song4()
        {
            val intent = Intent(this, MusicActivity::class.java)
                .putExtra("song" , 4)
            startActivity(intent)

        }
         fun song5()
        {
            val intent = Intent(this, MusicActivity::class.java)
                .putExtra("song" , 5)
            startActivity(intent)
        }

        @Composable
        fun Home_screen() {
            songCard(this , onClick1 = {song1()}, onClick2 = {song2()} , onClick3 = {song3()} ,onClick4 = {song4()} , onClick5 = {song5()})

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ){
                Button(onClick = { gotoFavourite() },
                    modifier = Modifier
                        .padding(15.dp)
                        .size(140.dp, 60.dp)

                ) {
                    Text(text = "Favourites",
                        fontSize = 20.sp)
                }
            }
        }

    @Preview
        @Composable
        fun Set_screen_view() {

        }
}

