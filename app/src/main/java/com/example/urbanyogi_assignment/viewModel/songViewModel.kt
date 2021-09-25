package com.example.urbanyogi_assignment.viewModel

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbanyogi_assignment.Class.Song
import com.example.urbanyogi_assignment.HomeActivity
import com.example.urbanyogi_assignment.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class songViewModel() : ViewModel() {


    private lateinit var auth: FirebaseAuth
    var user: FirebaseUser? = null




    val songsList : MutableLiveData<List<Song>> by lazy {
        MutableLiveData<List<Song>>()

    }


    val songList : ArrayList<Song> = ArrayList()
    init{
        getSongList()

    }

    fun getSongList() {
        fetchList()
        songsList.value = songList
    }

    fun fetchList() {
//        var songList: ArrayList<Song> = ArrayList()
//        auth = FirebaseAuth.getInstance()
//        user = auth.currentUser
//        var i : Int = 0
//        if (user != null) {
//            val db = Firebase.firestore
//            db.collection("tracks")
//                .get()
//                .addOnSuccessListener { document ->
//                    for(docu in document)
//                    {
//                        songList.add(Song(docu.data.get("id").toString(),
//                            docu.data.get("name").toString(),
//                            docu.data.get("artistName").toString(),
//                            docu.data.get("artistImage").toString(),
//                            docu.data.get("image").toString(),
//                            docu.data.get("trackUrl").toString()))
//
//                        Log.d("TAG", songList.get(i).name)
//                        i++
//                    }
//                }
//                .addOnFailureListener { e ->
//                    Log.d("TAG", "get failed with ", e)
//                }
//        }
//        songList.add(Song("a","a", "a","a", "a","a"))
//        songList.add(Song("a","a", "a","a", "a","a"))


    }

}