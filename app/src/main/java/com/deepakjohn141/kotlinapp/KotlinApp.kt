package com.deepakjohn141.kotlinapp

import android.app.Application
import com.deepakjohn141.kotlinapp.datamanager.DataManager
import com.deepakjohn141.kotlinapp.network.FactsRepository

class KotlinApp: Application() {
    val dataManager: DataManager by lazy { DataManager(this) }

    override fun onCreate() {
        super.onCreate()
    }
}