package com.artikdemonik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artikdemonik.myapplication.theme.AppTheme

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(
                    topBar = {
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer)){
                            Row(modifier = Modifier.padding(7.dp), verticalAlignment = Alignment.CenterVertically){
                                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "accountIcon", modifier = Modifier.size(45.dp))
                                Spacer(modifier = Modifier.size(15.dp))
                                Text(text = "Username Surname Patronymic", fontSize = 20.sp)
                            }
                        }
                    },
                    bottomBar = {
                        val iconSize = 30.dp
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFDDDDDD)), contentAlignment = Alignment.BottomCenter){
                            Row(
                                Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(7.dp), horizontalArrangement = Arrangement.SpaceAround){
                                Box(modifier = Modifier.clickable {
                                    val intent = Intent(this@ProfileActivity, MainWindowActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }){
                                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "homeScreen", Modifier.size(iconSize), tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                }
                                Box(modifier = Modifier.clickable {

                                }){
                                    Icon(imageVector = Icons.Outlined.AddCircleOutline, contentDescription = "addApplication", Modifier.size(iconSize), tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                }
                                Box(modifier = Modifier.clickable {

                                }){
                                    Icon(imageVector = Icons.Outlined.PersonOutline, contentDescription = "profile", Modifier.size(iconSize), tint = Color(0xFF0066FF))
                                }

                            }
                    }}
                ){
                    Column(modifier = Modifier.padding(it)){
                        ElevatedCard(modifier = Modifier
                            .padding(7.dp)
                            .fillMaxWidth()){
                            OutlinedCard(modifier = Modifier
                                .padding(7.dp)
                                .fillMaxWidth()){
                                Column (modifier = Modifier.padding(7.dp)){
                                    Text(text = "Surname: Иванов")
                                    Text(text = "Name: Иван")
                                    Text(text = "Patronymic: Иванович")
                                    Text(text = "Birthdate: 20.01.2006")
                                }
                            }

                        }
                    }
                }
            }

        }
    }


}