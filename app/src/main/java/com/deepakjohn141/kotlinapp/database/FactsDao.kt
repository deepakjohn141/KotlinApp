package com.deepakjohn141.kotlinapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepakjohn141.kotlinapp.database.constant.DBConstants
import com.deepakjohn141.kotlinapp.network.response.Fact

@Dao
interface FactsDao {

    @Query("SELECT * FROM ${DBConstants.TABLE_FACT_NAME}")
    fun getFacts(): LiveData<List<Fact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFacts(facts: List<Fact>)

    @Query("DELETE FROM ${DBConstants.TABLE_FACT_NAME}")
    suspend fun deleteAll()
}