package com.globant.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//Single
fun multiply(a : Int, b :Int) : Single<Int> {
    //Thread.sleep(2000)
    //return a * b
    return Single.create { emitter ->
        Thread.sleep(2000)
        emitter.onSuccess(a*b)
    }
}

//Completable
fun printValue(a : Int, b :Int)  : Completable {
    //Thread.sleep(2000)
    return Completable.create {emitter ->
        Thread.sleep(3000)
        
    }
}

fun getSeconds() = "${Thread.currentThread().name} ${System.currentTimeMillis()}"

fun main() {
    println("${getSeconds()} : Multiplying ...")
    multiply(1,2)
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.newThread())
        .subscribe { m ->
            println("${getSeconds()} : Multiplicacion de 1*2 = $m")
    }

    printValue(1,2)

    println("End SyncPart")
    println("FinishProgram")
}