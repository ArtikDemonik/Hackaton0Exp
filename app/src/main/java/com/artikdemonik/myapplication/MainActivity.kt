package com.artikdemonik.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
    fun Registration(){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight(0.7f)
            ){
                val login = remember{
                    mutableStateOf("")
                }
                Text(text = "Регистрация", fontSize = 30.sp, color = MaterialTheme.colorScheme.primary)
                InputText(value = login, placeholder = "СНИЛС")
                InputText(value = login, placeholder = "Имя")
                InputText(value = login, placeholder = "Фамилия")
                InputText(value = login, placeholder = "Отчество")
                InputText(value = login, placeholder = "Номер телефона")
                InputText(value = login, placeholder = "Пароль")
                InputText(value = login, placeholder = "Повтор пароля")
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text("Зарегистрироваться")
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), contentAlignment = Alignment.BottomCenter){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                Text("Уже есть акаунт?", color = MaterialTheme.colorScheme.primary)
                ElevatedButton(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )) {
                    Text("Войти")
                }
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
                Text("Ещё нет аккаунта?", color = MaterialTheme.colorScheme.primary)
                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text("Зарегистрироваться")
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
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text("Войти")
            }
        }
    }





}



