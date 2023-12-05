package com.artikdemonik.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
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
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

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
        val viewModel = RegisterVm(NetworkRepository(NetworkClient()))
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight(0.7f)
            ){
                val snils = remember{
                    mutableStateOf("")
                }
                val name = remember{
                    mutableStateOf("")
                }
                val surname = remember{
                    mutableStateOf("")
                }
                val patronymic = remember{
                    mutableStateOf("")
                }
                val phone = remember{
                    mutableStateOf("")
                }
                val password = remember{
                    mutableStateOf("")
                }
                val passwordRepeat = remember{
                    mutableStateOf("")
                }
                Text(text = "Регистрация", fontSize = 30.sp, color = MaterialTheme.colorScheme.primary)
                InputText(value = snils, placeholder = "СНИЛС")
                InputText(value = name, placeholder = "Имя")
                InputText(value = surname, placeholder = "Фамилия")
                InputText(value = patronymic, placeholder = "Отчество")
                InputText(value = phone, placeholder = "Номер телефона")
                InputText(value = password, placeholder = "Пароль")
                InputText(value = passwordRepeat, placeholder = "Повтор пароля")
                ElevatedButton(
                    onClick = {
                        viewModel.register(snils = snils.value,
                            name = name.value,
                            surname = surname.value,
                            patronymic = patronymic.value,
                            phone = phone.value,
                            password = password.value
                        )
                        Timer().schedule(timerTask{
                            if(viewModel.success.value!!){
                                val intent = Intent(this@RegisterActivity, MainWindowActivity::class.java)
                                startActivity(intent)
                            }
                        }, 3000
                        )
                    },
                    modifier = Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    enabled = password.value == passwordRepeat.value
                ) {
                    Text("Зарегистрироваться", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), contentAlignment = Alignment.BottomCenter){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.clickable {
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                }){
                    Text("Уже есть аккаунт? Войти", color = MaterialTheme.colorScheme.primary)
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

