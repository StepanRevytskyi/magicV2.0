package com.arondillqs5328.magicv20.database

import androidx.lifecycle.LiveData
import com.arondillqs5328.magicv20.MagicApplication
import com.arondillqs5328.magicv20.model.pojo.Data

class DatabaseHelper {

    fun getFavoritesCryptocurrency(): LiveData<List<Data>> {
        return CryptocurrencyDatabase
            .getDatabase(MagicApplication.INSTANCE)
            .favoritesDao()
            .getAllCryptocurrency()
    }

    fun insertCryptocurrency(data: Data) {
        //TODO: not implemented
    }

    fun deleteCryptocurrencyById(id: Int) {
        //TODO: not implemented
    }
}