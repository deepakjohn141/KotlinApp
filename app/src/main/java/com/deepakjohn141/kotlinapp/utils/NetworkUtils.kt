package com.deepakjohn141.kotlinapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo

class NetworkUtils {

    companion object {
        fun Context.isNetworkAvailable(): Boolean {
            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}