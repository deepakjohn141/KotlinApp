package com.deepakjohn141.kotlinapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deepakjohn141.kotlinapp.database.constant.DBConstants
import com.deepakjohn141.kotlinapp.network.response.Fact

@Database(entities = arrayOf(Fact::class), version = DBConstants.DATABASE_VERSION, exportSchema = false)
abstract class FactsDatabase : RoomDatabase() {

    abstract fun factsDao(): FactsDao

    companion object {
        @Volatile
        private var INSTANCE: FactsDatabase? = null

        fun getDatabase(context: Context): FactsDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactsDatabase::class.java,
                    DBConstants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}