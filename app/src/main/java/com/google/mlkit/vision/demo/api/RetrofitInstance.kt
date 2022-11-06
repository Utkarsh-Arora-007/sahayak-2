package com.google.mlkit.vision.demo.api

import com.google.mlkit.vision.demo.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance  {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://anvansh.pythonanywhere.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

}