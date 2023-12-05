package com.artikdemonik.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterVm(private val repository: NetworkRepository): ViewModel() {
    val success = MutableLiveData<Boolean>()
    fun register(snils: String, name: String, surname: String,
                 patronymic: String, phone: String, password: String){
        viewModelScope.launch {
            repository.register(snils, name, surname, patronymic, phone, password)
        }
    }
}