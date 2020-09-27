package com.deepakjohn141.kotlinapp.datamanager

import android.content.Context
import com.deepakjohn141.kotlinapp.database.FactsDatabase
import com.deepakjohn141.kotlinapp.network.FactsRepository
import com.deepakjohn141.kotlinapp.network.response.Fact

class DataManager(context: Context) {

   private val database = FactsDatabase.getDatabase(context)
   private val apiClient = FactsRepository.getApiClient()

    fun getFactsFromDataBase() = database.factsDao().getFacts()

    suspend fun insertFacts(facts: List<Fact>){
        database.factsDao().deleteAll()
        database.factsDao().insertFacts(facts)
    }

    fun getFactsFromServer() = apiClient.getFacts()
}