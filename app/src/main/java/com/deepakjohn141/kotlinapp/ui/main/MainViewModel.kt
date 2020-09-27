package com.deepakjohn141.kotlinapp.ui.main

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.deepakjohn141.kotlinapp.datamanager.DataManager
import com.deepakjohn141.kotlinapp.network.NetworkState
import com.deepakjohn141.kotlinapp.ui.base.BaseViewModel
import com.deepakjohn141.kotlinapp.utils.NetworkUtils.Companion.isNetworkAvailable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel(val dataManager: DataManager) : BaseViewModel() {

    val facts = dataManager.getFactsFromDataBase()

    fun refreshFacts(context: Context) {

        if (context.isNetworkAvailable()) {
            networkState.value = NetworkState.Loading
            dataManager.getFactsFromServer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response, throwable ->
                    response?.let {
                        networkState.value = NetworkState.Success
                        viewModelScope.launch {
                            it.rows.filter { !it.isEmpty() }.let {
                                if (it.isNotEmpty()) it[0].mainTitle = response.title
                                dataManager.insertFacts(it)
                            }
                        }
                    }
                    throwable?.let {
                        networkState.value = NetworkState.Error
                    }
                }.also { disposables.add(it) }
        } else {
            networkState.value = NetworkState.NetworkNotAvailable
        }

    }

}