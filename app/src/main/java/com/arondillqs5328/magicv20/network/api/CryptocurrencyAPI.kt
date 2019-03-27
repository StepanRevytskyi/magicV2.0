package com.arondillqs5328.magicv20.network.api

import com.arondillqs5328.magicv20.model.pojo.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptocurrencyAPI {

    @GET("v1/cryptocurrency/listings/latest")
    fun getCoins(@Query("start") start: Int,
                 @Query("limit") limit: Int): Call<Response>

}