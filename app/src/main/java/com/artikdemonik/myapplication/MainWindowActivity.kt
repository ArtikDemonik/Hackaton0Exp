package com.artikdemonik.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.artikdemonik.myapplication.theme.AppTheme

class MainWindowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                Column(modifier = Modifier.padding(20.dp)) {
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors(contentColor = Color.Red) //TODO
                    ){

                    }
                }
            }
        }
    }
}