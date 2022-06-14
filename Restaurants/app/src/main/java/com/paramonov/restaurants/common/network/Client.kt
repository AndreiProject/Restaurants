package com.paramonov.restaurants.common.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private const val BASE_URL = "https://api.openweathermap.org"
    private var retrofit: Retrofit? = null

    fun getNet(): Retrofit {
        if (retrofit == null) {
            val builder = OkHttpClient().newBuilder()
            retrofit = Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build()
        }
        return retrofit!!
    }

    private fun getGson() = GsonBuilder().apply {
        setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
    }.create()
}