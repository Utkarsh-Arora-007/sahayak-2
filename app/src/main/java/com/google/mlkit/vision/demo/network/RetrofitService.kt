package com.google.mlkit.vision.demo.network

import com.google.mlkit.vision.demo.dataclass.*
import retrofit2.http.GET

interface RetrofitService {

    @GET("malls")
    suspend fun getMalls (
    ): Malls

    @GET("libraries")
    suspend fun getLibraries (
    ): Libraries

    @GET("toilets")
    suspend fun getToilets (
    ): Toilets

    @GET("restraunts")
    suspend fun getRestraunts (
    ): Restraunts

    @GET("hospitals")
    suspend fun getHospitals (
    ): Hospitals

    @GET("banks")
    suspend fun getBanks (
    ):Banks

}

