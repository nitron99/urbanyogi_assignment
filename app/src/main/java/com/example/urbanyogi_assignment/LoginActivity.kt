package com.example.urbanyogi_assignment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.urbanyogi_assignment.Class.Song
import com.example.urbanyogi_assignment.ui.theme.UrbanYogi_assignmentTheme
import com.example.urbanyogi_assignment.viewModel.songViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    var user: FirebaseUser? = null

    private var text = mutableStateOf("text")

    val songList: ArrayList<Song> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbanYogi_assignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Login_screen()
                }
            }
        }

        auth = FirebaseAuth.getInstance()
        //viewModel.fetchList()



    }

    fun fetch() {

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser
        var i : Int = 0
        if (user != null) {
            val db = Firebase.firestore
            db.collection("tracks")
                .get()
                .addOnSuccessListener { document ->
                    for(docu in document)
                    {
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


    override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null)
        {
            updateUI(currentUser)
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        val intent = Intent(this, HomeActivity::class.java)
            .putExtra("List", songList)
        startActivity(intent)
    }

    private fun login_btn(email: String, password: String) {
        loginUser(email , password)

    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    fetch()
                    updateUI(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()



                }
            }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }


    @Composable
    fun Login_screen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Login" ,
                fontSize = 50.sp,
                modifier = Modifier
                    .padding(bottom = 40.dp))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.padding(bottom = 40.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    login_btn(email, password)
                },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .size(width = 200.dp , height = 60.dp)
            ){
                Text(text = "Login",
                    fontSize = 25.sp)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview4() {
        UrbanYogi_assignmentTheme {
            Login_screen()
        }
    }


}