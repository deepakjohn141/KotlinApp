package com.deepakjohn141.kotlinapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deepakjohn141.kotlinapp.network.NetworkState
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    protected val disposables: CompositeDisposable by lazy { CompositeDisposable() }
    val networkState: MutableLiveData<NetworkState> by lazy {  MutableLiveData<NetworkState>() }

    override fun onCleared() {
        if (disposables.size() > 0 && disposables.isDisposed.not()){
            disposables.dispose()
        }
        super.onCleared()
    }
}