package me.immathan.xring

import java.util.*

class Server(var address: String) {

    fun process(request: Request) {
        Thread().run {
            print("Requesting from address: " + address)
            val mockProcessTime = Random().nextInt(10000)
            Thread.sleep(mockProcessTime.toLong())
            request.finished()
        }
    }

}