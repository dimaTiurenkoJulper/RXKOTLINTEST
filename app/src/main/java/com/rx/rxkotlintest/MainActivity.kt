package com.rx.rxkotlintest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class MainActivity : AppCompatActivity() {
    var TAG = "Logs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener { startRStream() }

    }

    private fun startRStream() {

        val list = listOf("1", "2", "3", "4", "5")

//Apply the toObservable() extension function//

        list.toObservable()

//Construct your Observer using the subscribeBy() extension function//
                .subscribeBy(
                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("onComplete!") }

                )
    }
}