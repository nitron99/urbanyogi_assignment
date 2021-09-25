package com.example.urbanyogi_assignment.ui.theme.components


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberImagePainter
import com.bumptech.glide.Glide
import com.example.urbanyogi_assignment.Class.Song
import com.example.urbanyogi_assignment.FavourActivity
import com.example.urbanyogi_assignment.HomeActivity
import com.example.urbanyogi_assignment.MusicActivity
import com.example.urbanyogi_assignment.R
import java.security.AccessController.getContext
import kotlin.math.absoluteValue

@Composable
fun songCard(
    c : Context,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    onClick4: () -> Unit,
    onClick5: () -> Unit,
){
    Column(
        modifier = Modifier
            .scrollable(ScrollableState { 0F }, orientation = Orientation.Vertical)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        //MaterialTheme.colors.primaryVariant
                        Color.Black
                    )
                )
            )
            .padding(15.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp)
                .height(110.dp)
                .fillMaxWidth()
                .clickable(onClick = { onClick1() }),

            elevation = 8.dp
        )
        {
            Row(){
                Image(
                    painter = rememberImagePainter("https://cdn.urbanyogi.app/image%2Fbright%20moon.jpg"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp),
                    contentScale = ContentScale.Crop

                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ){
                        Text(text = "Bright Moon",
                            fontSize = 25.sp)
                }
            }
        }

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp)
                .fillMaxWidth()
                .height(110.dp)
                .clickable(onClick = onClick2),
            elevation = 8.dp
        )
        {
            Row(){
                Image(
                    painter = rememberImagePainter("https://cdn.urbanyogi.app/image%2Fcosmic%20love.jpeg"),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )

                Column (modifier = Modifier
                        .padding(8.dp)){
                    Text(text = "Cosmic Love",
                        fontSize = 25.sp)
                }
            }
        }

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp)
                .fillMaxWidth()
                .height(110.dp)
                .clickable(onClick = onClick3),
            elevation = 8.dp
        )
        {
            Row(){
                Image(
                    painter = rememberImagePainter("https://cdn.urbanyogi.app/image/nathaniel-shuman-5AMqioV56ic-unsplash.jpg"),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ){
                    Text(text = "Daily Calm",
                        fontSize = 25.sp)
                }
            }
        }

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp)
                .fillMaxWidth()
                .height(110.dp)
                .clickable(onClick = onClick4),
            elevation = 8.dp
        )
        {
            Row(){
                Image(
                    painter = rememberImagePainter("https://cdn.urbanyogi.app/image/RelaxingbeforesleepF.png"),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ){
                    Text(text = "Deep Sleep",
                        fontSize = 25.sp)
                }
            }
        }

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp)
                .fillMaxWidth()
                .height(110.dp)
                .clickable(onClick = onClick5),
            elevation = 8.dp
        )
        {
            Row(){
                Image(
                    painter = rememberImagePainter("https://cdn.urbanyogi.app/image/francesco-ungaro-FmkSTYoZXx0-unsplash-app.jpg"),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )



                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ){
                    Text(text = "Purple Light",
                        fontSize = 25.sp)
                }
            }
        }

    }



}





