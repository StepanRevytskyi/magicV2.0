package com.arondillqs5328.magicv20.repository.detail

import com.arondillqs5328.magicv20.network.api.CryptocurrencyAPI
import com.arondillqs5328.magicv20.repository.Callback

class DetailRepository(private val api: CryptocurrencyAPI,
                       private val callback: Callback) : Repository {

    override fun loadData(id: Int) {

    }
}