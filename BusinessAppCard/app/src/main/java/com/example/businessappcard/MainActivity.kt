package com.example.businessappcard

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businessappcard.ui.theme.BusinessAppCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessAppCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) { innerPadding ->
                    ImageNameTitle(
                        name = "Pablo González Pérez",
                        title = "Computer Science Student",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ContactInfo(
                        phone="+34 000 000 000",
                        username="@Pablogp410",
                        email="pablogp01@gmail.com",
                        modifier=Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NameAndTitle(name: String, title: String, modifier: Modifier = Modifier) {
    Column (
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = name,
            //textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color=Color.White,
            modifier = modifier
        )
        Text(
            text = title,
            fontSize = 15.sp,
            //textAlign = TextAlign.Center,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }
}

@Composable
fun ImageNameTitle(name:String, title: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=modifier.fillMaxSize()
    ){
        Spacer(Modifier.padding(top=250.dp))
        Image(
            painter = image,
            contentDescription = "Android",
            modifier.height(100.dp),
            //contentScale = ContentScale.Crop
        )
        NameAndTitle(name, title, modifier)
    }
}

@Composable
fun ContactInfo(phone:String, username:String, email:String, modifier: Modifier=Modifier){
    Column(
        modifier=modifier.fillMaxSize()
            .padding(horizontal = 80.dp)
    ){
        Spacer(Modifier.padding(top=700.dp))
        PhoneRow(phone, modifier)
        Spacer(Modifier.padding(top=5.dp))
        LinkRow(username, modifier)
        Spacer(Modifier.padding(top=5.dp))
        EmailRow(email, modifier)
    }
}

@Composable
fun PhoneRow(phone:String, modifier: Modifier){
    Row(
        modifier=modifier
    ){
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = "Phone icon",
            tint=Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier.padding(start = 30.dp))
        Text(
            text=phone,
            color = Color.White ,
            modifier = modifier
        )
    }
}

@Composable
fun LinkRow(username:String, modifier: Modifier){
    Row(
        modifier=modifier
    ){
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "username icon",
            tint=Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier.padding(start = 30.dp))
        Text(
            text=username,
            color = Color.White,
            modifier = modifier
        )
    }
}

@Composable
fun EmailRow(email:String, modifier: Modifier){
    Row(
        modifier=modifier
    ){
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "email icon",
            tint=Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier.padding(start = 30.dp))
        Text(
            text=email,
            color = Color.White,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessAppCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) { innerPadding ->
            ImageNameTitle(
                name = "Pablo González Pérez",
                title = "Computer Science Student",
                modifier = Modifier.padding(innerPadding)
            )
            ContactInfo(
                phone="+34 000 000 000",
                username="@Pablogp410",
                email="pablogp01@gmail.com",
                modifier=Modifier.padding(innerPadding)
            )
        }
    }
}