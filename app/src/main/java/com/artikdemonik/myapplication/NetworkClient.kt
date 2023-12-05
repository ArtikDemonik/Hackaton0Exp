package com.artikdemonik.myapplication

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.utils.io.*
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

class NetworkClient() {
    val answer = MutableLiveData<Map<*, *>>()
    private suspend fun connect(): Socket {
        return aSocket(
            ActorSelectorManager(
                Executors.newCachedThreadPool()
                    .asCoroutineDispatcher()
            )
        )
            .tcp()
            .connect(InetSocketAddress("192.168.62.170", 8003))
    }

    suspend fun sendRequest(text: String): Answer? {
        //Log.d("qwe", "ПОДКЛЮЧАЮСЬ")
        val socket = connect()
        socket.openWriteChannel(autoFlush = true).writeStringUtf8(text)
        val reader = socket.openReadChannel()
        val answer = reader.readUTF8Line().toString()
        //Log.d("qwe", answer)
        return Gson().fromJson(answer, Answer::class.java)

    }
}