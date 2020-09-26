package com.deepakjohn141.kotlinapp.database.constant

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepakjohn141.kotlinapp.network.response.Fact

@Dao
interface FactsDao {

    @Query("SELECT * FROM ${DBConstants.TABLE_FACTS}")
    fun getFacts(): List<Fact>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFacts(facts: List<Fact>)

    @Query("DELETE FROM ${DBConstants.TABLE_FACTS}")
    suspend fun deleteAll()
}