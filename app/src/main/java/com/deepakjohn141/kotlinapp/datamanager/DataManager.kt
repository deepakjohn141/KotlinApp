package com.deepakjohn141.kotlinapp.datamanager

import android.content.Context
import com.deepakjohn141.kotlinapp.database.FactsDatabase
import com.deepakjohn141.kotlinapp.network.FactsRepository

class DataManager(context: Context) {
    val database = FactsDatabase.getDatabase(context)
    val apiClient = FactsRepository.getApiClient()
}