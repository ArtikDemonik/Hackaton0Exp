package com.artikdemonik.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artikdemonik.myapplication.theme.AppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                Registration()
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
                ElevatedButton(onClick = { val intent = Intent(this@RegisterActivity, MainActivity::class.java) },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )) {
                    Text("Войти")
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
}

