package com.deepakjohn141.kotlinapp

import android.app.Application
import com.deepakjohn141.kotlinapp.network.FactsRepository

class KotlinApp: Application() {
    val factsRepository: FactsRepository  by lazy { FactsRepository }
}