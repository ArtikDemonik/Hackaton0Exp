package com.artikdemonik.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artikdemonik.myapplication.theme.AppTheme

class MainWindowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                val horizontalGradientBrush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFff0033),
                    Color(0xFFff9933)
                )
            )
                Scaffold(
                    topBar = {
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(13.dp),
                            elevation = CardDefaults.cardElevation(12.dp),
                    ){
                        Box(modifier = Modifier
                            .background(horizontalGradientBrush)
                            .fillMaxWidth()){
                            Column (modifier = Modifier.padding(6.dp)){
                                Text("Статус вашей заявки:", fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimary)
                                Text("3 декабря", fontSize = 14.sp, color = MaterialTheme.colorScheme.onPrimary)
                                Text("01928310928301928388", fontSize = 14.sp, color = MaterialTheme.colorScheme.onPrimary)
                                Text("Заявка отклонена", fontSize = 17.sp, color = MaterialTheme.colorScheme.onPrimary)
                            }
                        }
                    }},
                    modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer)
                    ,
                    bottomBar = {
                            val iconSize = 30.dp
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFDDDDDD)), contentAlignment = Alignment.BottomCenter){
                                Row(
                                    Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(7.dp), horizontalArrangement = Arrangement.SpaceAround){
                                    Box(){
                                        Icon(imageVector = Icons.Outlined.Home, contentDescription = "homeScreen", Modifier.size(iconSize), tint = Color(0xFF0066FF))
                                    }
                                    Box(modifier = Modifier.clickable {

                                    }){
                                        Icon(imageVector = Icons.Outlined.AddCircleOutline, contentDescription = "addApplication", Modifier.size(iconSize), tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                    }
                                    Box(modifier = Modifier.clickable {
                                        val intent = Intent(this@MainWindowActivity, ProfileActivity::class.java)
                                        startActivity(intent)
                                    }){
                                        Icon(imageVector = Icons.Outlined.PersonOutline, contentDescription = "profile", Modifier.size(iconSize), tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                    }

                                }
                            }

                    }

                ){
                    Column(modifier = Modifier
                        .padding(it)
                        .padding(13.dp, 0.dp)) {
                        Text("История заявок", fontSize = 25.sp, color = MaterialTheme.colorScheme.primary)
                        LazyColumn(){
                            item{
                                ListItem(date = "3 декабря", status = "Отклонена", description = "Поданы неверные данные", pointColor = Color(0xffff0033))}
                        }
                    }
                }

            }
        }
    }

    @Composable
    fun ListItem(date: String, status: String, description: String, pointColor: Color){
        OutlinedCard (modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondary)
            ){
                Column(modifier = Modifier.padding(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(date)
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .size(7.dp)
                                .background(color = pointColor)
                        )
                    }
                    Text(text = status, color = pointColor)
                    Text(description)
                }

            }
        Spacer(modifier = Modifier.size(7.dp))
    }
}