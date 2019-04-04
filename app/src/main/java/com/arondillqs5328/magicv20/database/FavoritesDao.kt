package com.arondillqs5328.magicv20.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arondillqs5328.magicv20.model.pojo.Data

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorites")
    fun getAllCryptocurrency(): LiveData<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCryptocurrency(data: Data)

    @Query("DELETE FROM favorites WHERE `id` = :id")
    fun deleteCryptocurrencyById(id: Int)
}