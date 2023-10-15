package com.example.databinding.webService

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient private constructor() {

    private var _service: ApiInterface? = null
    val service: ApiInterface?
        get() {
            if (_service == null) {
                _service = retrofitCAS.create(ApiInterface::class.java)
            }
            return _service
        }


    private val retrofitCAS: Retrofit
        get() {

            val httpClient = OkHttpClient.Builder()
            httpClient.writeTimeout(1, TimeUnit.MINUTES)
            httpClient.readTimeout(1, TimeUnit.MINUTES)
            httpClient.connectTimeout(1, TimeUnit.MINUTES)

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl("http://restapi.adequateshop.com")
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    companion object {
        @JvmStatic
        val instance = ApiClient()
    }
}