package com.deepakjohn141.kotlinapp.ui.main

import androidx.lifecycle.viewModelScope
import com.deepakjohn141.kotlinapp.datamanager.DataManager
import com.deepakjohn141.kotlinapp.network.NetworkState
import com.deepakjohn141.kotlinapp.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel(val dataManager: DataManager) : BaseViewModel() {

    val factsDao = dataManager.database.factsDao()
    val facts =  factsDao.getFacts()

    fun refreshFacts() {
        networkState.value = NetworkState.Loading
        dataManager.apiClient
            .getFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response, throwable ->
                response?.let {
                    networkState.value = NetworkState.Success
                    viewModelScope.launch {
                        it.rows.filter { !it.isEmpty() }.let {
                            if(it.isNotEmpty()) it[0].mainTitle = response.title
                            factsDao.deleteAll()
                            factsDao.insertFacts(it)
                        }
                    }
                }
                throwable?.let {
                    networkState.value = NetworkState.Error
                }
            }.also { disposables.add(it) }
    }

}