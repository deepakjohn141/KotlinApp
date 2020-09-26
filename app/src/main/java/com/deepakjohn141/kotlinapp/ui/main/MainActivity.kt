package com.deepakjohn141.kotlinapp.ui.main


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.deepakjohn141.kotlinapp.R
import com.deepakjohn141.kotlinapp.adapter.FactListingAdapter
import com.deepakjohn141.kotlinapp.databinding.MainActivityBinding
import com.deepakjohn141.kotlinapp.network.NetworkState
import com.deepakjohn141.kotlinapp.ui.base.BaseActivity
import com.deepakjohn141.kotlinapp.ui.base.BaseViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    val factListingAdapter: FactListingAdapter by lazy { FactListingAdapter() }
    val viewModel: MainViewModel by lazy { MainViewModel(dataManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBinding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        activityBinding.viewModel = viewModel
        activityBinding.adapter = factListingAdapter
        startObserving()
        viewModel.refreshFacts()
    }

    fun startObserving(){

        viewModel.facts.observe(this, Observer {
            factListingAdapter.setData(it)
            supportActionBar?.title = if(it.isNotEmpty())  it[0].mainTitle else ""
        })

        (viewModel as BaseViewModel).networkState.observe(this, Observer {
            when(it){
                is NetworkState.NetworkNotAvailable -> swiperefresh.isRefreshing = false
                is NetworkState.Error -> swiperefresh.isRefreshing = false
                is NetworkState.Success -> swiperefresh.isRefreshing = false
                is NetworkState.Loading -> swiperefresh.isRefreshing = true
            }
        })
    }

}