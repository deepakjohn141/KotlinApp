package com.deepakjohn141.kotlinapp.network

sealed class NetworkState {
    object Loading : NetworkState()
    object Error : NetworkState()
    object Success : NetworkState()
    object NetworkNotAvailable : NetworkState()
}