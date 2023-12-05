package com.artikdemonik.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginVM(private val repository: NetworkRepository): ViewModel() {

    fun login(snils: String, password: String){
        viewModelScope.launch {

        }
    }
}