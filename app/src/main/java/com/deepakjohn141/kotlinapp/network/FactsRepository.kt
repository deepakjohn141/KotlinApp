package com.deepakjohn141.kotlinapp.network

import com.deepakjohn141.kotlinapp.network.constant.ApiUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FactsRepository {
    private val apiInterface: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    fun getFacts() = apiInterface.getFacts()
}