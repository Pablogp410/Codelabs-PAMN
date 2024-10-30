package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithDescription(
                        modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
                    )
                }
            }
        }
    }
}

@Composable
fun ImageWithDescription(modifier: Modifier){
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.triton
        2 -> R.drawable.homenaje_a_los_labrantes
        3 -> R.drawable.el_atlante
        4 -> R.drawable.monumento_al_poeta
        else -> R.drawable.lady_harimaguada
    }
    val imageText = when (result) {
        1 -> "Exordio el Tritón"
        2 -> "Homenaje a los labrantes"
        3 -> "El atlante"
        4 -> "Monumento al poeta"
        else -> "Lady Harimaguada"
    }
    val authors = when (result) {
        1 -> "Manolo González (2011)"
        2 -> "Felo Monzón(1986)"
        3 -> "Tony Gallardo(1986)"
        4 -> "Juan Bordes(1998)"
        else -> "Martín Chirino(1996)"
    }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = imageText,
            modifier= Modifier.padding(horizontal = 30.dp).height(500.dp).padding(top=80.dp),
            contentScale = ContentScale.Crop,
        )
        //Spacer(modifier = Modifier.height(16.dp))
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.wrapContentSize()
            //modifier = Modifier.fillMaxSize()
        ){
            Text(
                text=imageText,
                fontSize= 35.sp,
                fontWeight = FontWeight.Bold,
                modifier =  Modifier.padding(top = 20.dp)
            )
            Spacer(Modifier.padding(vertical = 0.dp))
            Text(
                text=authors,
                modifier = Modifier.padding(top = 0.dp)
            )
        }
        Row(
            modifier=modifier
        ){
            Button(onClick = {
                if(result>1) result -= 1
                else result=5
            }){
                Text("Previous")
            }
            Spacer(Modifier.padding(horizontal = 40.dp))
            Button(onClick = {
                if(result<5) result += 1
                else result=1
            }){
                Text("Next")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ImageWithDescription(modifier = Modifier.fillMaxSize().wrapContentSize())
    }
}