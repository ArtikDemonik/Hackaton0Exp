package com.artikdemonik.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    Color(0xFF0099FF),
                    Color(0xFF99CCFF)
                )
            )
                Column(modifier = Modifier.padding(13.dp)) {
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(12.dp)
                    ){
                        Box(modifier = Modifier
                            .background(horizontalGradientBrush)
                            .fillMaxWidth()){
                            Column (modifier = Modifier.padding(6.dp)){
                                Text("Статус вашей заявки:", fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimary)
                                Text("17 ноября", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("01928310928301928388", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("Заявка отклонена", fontSize = 17.sp, color = MaterialTheme.colorScheme.onPrimary)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Text("История заявок", fontSize = 25.sp, color = MaterialTheme.colorScheme.primary)
                    LazyColumn{
                        item{
                            ListItem(date = "17 alskdjlas", status = "laskdjl/JAS;ldkajlskd", description = "alsdjlasdlak", pointColor = Color.Red)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ListItem(date: String, status: String, description: String, pointColor: Color){
        OutlinedCard (modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier.padding(6.dp)){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(date)
                    Box(
                        Modifier
                            .clip(CircleShape)
                            .size(7.dp)
                            .background(color = pointColor))
                }
                Text(status)
                Text(description)
            }

        }
    }
}