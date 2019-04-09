package com.arondillqs5328.magicv20.network

import com.arondillqs5328.magicv20.network.api.CryptocurrencyAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {

    private val API_URL: String = "https://pro-api.coinmarketcap.com"
    private val API_HEADER: String = "X-CMC_PRO_API_KEY"
    private val API_KEY: String = "63405db2-b682-4c22-8af7-255b21e3f09d"

    fun createAPI(): CryptocurrencyAPI {
        return getRetrofit().create(CryptocurrencyAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getInterceptor())
            .build()
    }

    private fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(API_HEADER, API_KEY)
                .build()

            chain.proceed(request)
        }
    }
}