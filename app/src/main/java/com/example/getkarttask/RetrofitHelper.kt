package com.example.getkarttask

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val baseUrl = "https://dummyapi.io/data/v1/"

    fun getApiService(): ApiService {
        val client = OkHttpClient().newBuilder().addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().addHeader("app-id", "6211e0c83a9ea15bc6e2618b").build()
            )
        }.build()
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        ).client(client).build().create(ApiService::class.java)
    }
}