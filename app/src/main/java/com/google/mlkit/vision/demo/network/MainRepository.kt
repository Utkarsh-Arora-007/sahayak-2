package com.google.mlkit.vision.demo.network

import com.google.mlkit.vision.demo.api.RetrofitInstance
import com.google.mlkit.vision.demo.dataclass.*

class MainRepository () {

    suspend fun getMalls(
    ): Malls {
        return RetrofitInstance.api.getMalls()
    }

    suspend fun getLibraries (
    ): Libraries {
        return RetrofitInstance.api.getLibraries()
    }

    suspend fun getToilets (
    ): Toilets {
        return RetrofitInstance.api.getToilets()
    }

    suspend fun getRestraunts (
    ): Restraunts {
        return RetrofitInstance.api.getRestraunts()
    }

    suspend fun getHospitals (
    ): Hospitals {
        return RetrofitInstance.api.getHospitals()
    }

    suspend fun getBanks (
    ): Banks{
        return RetrofitInstance.api.getBanks()
    }


}