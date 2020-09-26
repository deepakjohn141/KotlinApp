package com.deepakjohn141.kotlinapp.ui.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable

 open class BaseActivity: AppCompatActivity() {

    val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onDestroy() {
        if (disposable.size() > 0 && disposable.isDisposed.not()){
            disposable.dispose()
        }
        super.onDestroy()
    }
}