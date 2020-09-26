package com.deepakjohn141.kotlinapp.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val disposable: CompositeDisposable by lazy { CompositeDisposable() }


    override fun onCleared() {
        if (disposable.size() > 0 && disposable.isDisposed.not()){
            disposable.dispose()
        }
        super.onCleared()
    }
}