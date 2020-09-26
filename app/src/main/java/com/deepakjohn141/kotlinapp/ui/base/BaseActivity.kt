package com.deepakjohn141.kotlinapp.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.deepakjohn141.kotlinapp.KotlinApp
import com.deepakjohn141.kotlinapp.datamanager.DataManager
import io.reactivex.rxjava3.disposables.CompositeDisposable

 open class BaseActivity: AppCompatActivity() {

    val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    val dataManager: DataManager by lazy { (application as KotlinApp).dataManager }

    override fun onDestroy() {
        if (disposable.size() > 0 && disposable.isDisposed.not()){
            disposable.dispose()
        }
        super.onDestroy()
    }
}