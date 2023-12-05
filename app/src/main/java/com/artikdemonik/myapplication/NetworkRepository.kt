package com.artikdemonik.myapplication

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository(private val network: NetworkClient) {
    suspend fun login(login: String, password: String){
        return withContext(Dispatchers.IO){
            val request = Request("login", mapOf())
        }
    }

    suspend fun register(snils: String, name: String, surname: String,
                         patronymic: String, phone: String, password: String): Boolean {
        return withContext(Dispatchers.IO){
            val request = Request("mobileRegisterUserRequest", mapOf(pairs = arrayOf(
                Pair("snils", snils),
                Pair("name", name),
                Pair("surname", surname),
                Pair("patronymic", patronymic),
                Pair("phone", phone),
                Pair("password", password)
            )))
            val jsonRequest = Gson().toJson(request)
            val serverAnswer = network.sendRequest(jsonRequest)
            val result = serverAnswer?.MapAttributes?.get("answer")
            return@withContext result == "1"
        }
    }
}