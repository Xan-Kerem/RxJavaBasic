package com.cefer.rxjavabasic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "Cefffer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.just(1, 2, 3, 4, 5)

        val observer = object : Observer<Int> {

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: Int?) {
                Log.d(TAG, "onNext: $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }

        }

        observable.subscribe(observer)
    }
}