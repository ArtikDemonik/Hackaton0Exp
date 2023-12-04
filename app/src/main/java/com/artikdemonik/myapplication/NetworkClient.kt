package com.artikdemonik.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.InetSocketAddress
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.writeByte
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class NetworkClient() {
    val answer = MutableLiveData<String>()
    suspend fun connect(): Socket {
        //val socket = Socket("192.168.84.170", 8003)
        return aSocket(
            ActorSelectorManager(
                Executors.newCachedThreadPool()
                    .asCoroutineDispatcher()
            )
        )
            .tcp()
            .connect(InetSocketAddress("192.168.84.170", 8003))
    }

     fun sendRequest(text: String) {
         Log.d("qwe", "ПОДКЛЮЧАЮСЬ")
         CoroutineScope(Dispatchers.IO).launch {
             val socket = connect()
             socket.openWriteChannel(autoFlush = true).writeStringUtf8(text)
             Log.d("qwe", socket.openReadChannel().readUTF8Line().toString())
         }

    }
}