package com.deepakjohn141.kotlinapp.network

import androidx.lifecycle.LiveData
import com.deepakjohn141.kotlinapp.network.constant.ApiUrl
import com.deepakjohn141.kotlinapp.network.response.FactsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiUrl.GET_FACTS)
    fun getFacts(): Single<FactsResponse>
}