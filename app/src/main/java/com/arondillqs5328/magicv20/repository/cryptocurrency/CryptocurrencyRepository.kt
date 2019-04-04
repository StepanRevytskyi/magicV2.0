package com.arondillqs5328.magicv20.repository.cryptocurrency

import com.arondillqs5328.magicv20.model.pojo.Response
import com.arondillqs5328.magicv20.network.api.CryptocurrencyAPI
import retrofit2.Call

class CryptocurrencyRepository(private val api: CryptocurrencyAPI,
                               private val callback: Callback) : Repository {

    override fun loadMore(start: Int, limit: Int) {
        val call: Call<Response> = api.getCoins(start, limit)
        call.enqueue(object : retrofit2.Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful) {
                    if (response.body()?.status?.error_code ?: -1 == 0) {
                        response.body()?.data?.let { callback.onSuccess(it) }
                    }
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                callback.onFailed()
            }
        })
    }
}