package com.arondillqs5328.magicv20.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arondillqs5328.magicv20.model.pojo.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class CryptocurrencyDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    companion object {
        @Volatile
        var INSTANCE: CryptocurrencyDatabase? = null

        fun getDatabase(context: Context): CryptocurrencyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptocurrencyDatabase::class.java,
                    "cryptocurrency_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}