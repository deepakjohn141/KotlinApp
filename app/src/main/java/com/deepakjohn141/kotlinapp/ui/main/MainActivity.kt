package com.deepakjohn141.kotlinapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deepakjohn141.kotlinapp.R
import com.deepakjohn141.kotlinapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }
}