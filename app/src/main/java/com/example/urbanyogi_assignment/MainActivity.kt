package com.example.urbanyogi_assignment

import android.R.attr
import android.R.attr.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.urbanyogi_assignment.ui.theme.UrbanYogi_assignmentTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast

import com.google.firebase.auth.AuthResult

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity


class MainActivity : ComponentActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbanYogi_assignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Welcome_screen()
                }
            }
        }
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart(){
        super.onStart()
        val currentUser = mAuth.currentUser
        if(currentUser!= null)
        {
            updateUI(currentUser);
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun Login_btn(){
        val startAct = Intent(this, LoginActivity::class.java)
        startActivity(startAct)
        this.finish()
    }

    fun Signup_btn() {
        val startAct = Intent(this, SignupActivity::class.java)
        startActivity(startAct)
        this.finish()
    }


    @Composable
    fun Welcome_screen(){
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.primaryVariant
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = "Welcome!",
                    fontSize = 50.sp,
                    modifier = Modifier.padding(bottom = 100.dp),
                    color = Color.White
                )
                //login_btn
                Button(
                    onClick = {
                        Login_btn()
                    },
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .size(250.dp, 60.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan)

                )
                {
                    Text(
                        text = "Login",
                        fontSize = 25.sp,
                        color = Color.Black

                    )
                }
                //signup_btn
                Button(
                    onClick = {
                        Signup_btn()
                    },
                    modifier = Modifier
                        .size(250.dp, 60.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan)
                ) {
                    Text(
                        text = "Signup",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        UrbanYogi_assignmentTheme {
            Welcome_screen()
        }
    }


}









