package com.lkb.questions

import kotlinx.coroutines.*
//
//fun main() {
//    GlobalScope.launch {
//        // launch new coroutine in background and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
//    println("Hello,") // main thread continues while coroutine is delayed
//    //Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
//    runBlocking {
//        delay(
//                2000L
//        )
//    }
//}

//fun main()= runBlocking<Unit>{
//    val job = GlobalScope.launch {
//        delay(1000L)
//        println("world")
//    }
//    println("Hello")
//    job.join()
//}
// better example
fun main() = runBlocking { // this: CoroutineScope
    launch { // launch new coroutine in the scope of runBlocking
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}