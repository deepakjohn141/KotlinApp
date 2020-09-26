package com.deepakjohn141.kotlinapp.network

import com.deepakjohn141.kotlinapp.network.constant.ApiUrl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object FactsRepository {
    private var apiInterface: ApiInterface? = null

    fun getApiClient(): ApiInterface {
        if (apiInterface == null) {
            apiInterface = Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create(ApiInterface::class.java)
        }
        return apiInterface!!
    }


}