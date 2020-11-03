package com.example.tymes.utills.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConnect {

    private const val BASE_URL = ""
    private lateinit var httpClient: OkHttpClient.Builder
    fun retrofitCall(): APIClient {

        if (!(::httpClient.isInitialized)) {
            httpClient = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(APIClient::class.java)

    }
}