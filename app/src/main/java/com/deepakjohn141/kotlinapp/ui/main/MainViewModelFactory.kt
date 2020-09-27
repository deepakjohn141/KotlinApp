package com.deepakjohn141.kotlinapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deepakjohn141.kotlinapp.datamanager.DataManager
import java.lang.IllegalArgumentException

class MainViewModelFactory(val dataManager: DataManager): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataManager) as T
        }
        throw IllegalArgumentException("Unknown Model class")
    }
}