package com.artikdemonik.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
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
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondaryContainer
                )
            )
                Column(modifier = Modifier.padding(20.dp)) {
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth() //TODO
                    ){
                        Box(modifier = Modifier.background(horizontalGradientBrush).fillMaxWidth()){
                            Column (modifier = Modifier.padding(5.dp)){
                                Text("Статус вашей заявки:", fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimary)
                                Text("17 ноября", fontSize = 14.sp)
                                Text("019283109283019283", fontSize = 14.sp)
                                Text("Заявка на рассмотрении", fontSize = 17.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}