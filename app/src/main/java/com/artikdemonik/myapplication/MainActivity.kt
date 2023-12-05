package com.artikdemonik.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artikdemonik.myapplication.theme.AppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Authorize()
            }
        }
    }


    @Composable
    fun Authorize(){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            AuthorizeCenter()
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), contentAlignment = Alignment.BottomCenter ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.clickable {
                    val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }){
                    Text(
                        text = "  Ещё нет аккаунта? \n Зарегестрироваться",
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputText(value: MutableState<String>, placeholder: String){
        TextField(
            value = value.value,
            onValueChange = { value.value = it},
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            placeholder = {Text(placeholder)},
            singleLine = true)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AuthorizeCenter(){
        val viewModel = LoginVM(NetworkRepository(NetworkClient()))
        val login = remember{
            mutableStateOf("")
        }
        val password = remember{
            mutableStateOf("")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(0.35f)
        ) {
            Text(text = "Авторизация", fontSize = 30.sp, color = MaterialTheme.colorScheme.primary)
            InputText(value = login, placeholder = "Номер или СНИЛС")
            InputText(value = password, placeholder = "Пароль")
            ElevatedButton(
                onClick = {
                },
                modifier = Modifier.fillMaxWidth(0.4f),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Войти", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }





}



