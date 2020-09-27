package com.deepakjohn141.kotlinapp.ui.main


import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deepakjohn141.kotlinapp.R
import com.deepakjohn141.kotlinapp.adapter.FactListingAdapter
import com.deepakjohn141.kotlinapp.databinding.MainActivityBinding
import com.deepakjohn141.kotlinapp.network.NetworkState
import com.deepakjohn141.kotlinapp.ui.base.BaseActivity
import com.deepakjohn141.kotlinapp.ui.base.BaseViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    val factListingAdapter: FactListingAdapter by lazy { FactListingAdapter() }
    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = MainViewModelFactory(dataManager)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val activityBinding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        activityBinding.viewModel = viewModel
        activityBinding.adapter = factListingAdapter

        startObserving()

        viewModel.refreshFacts(this)
    }

    fun startObserving(){

        viewModel.facts.observe(this, Observer {
            factListingAdapter.setData(it)
            supportActionBar?.title = if(it.isNotEmpty())  it[0].mainTitle else ""
        })

        (viewModel as BaseViewModel).networkState.observe(this, Observer {
            when(it){
                is NetworkState.NetworkNotAvailable ->{ swiperefresh.isRefreshing = false
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle(getString(R.string.network_not_available))
                    builder.setPositiveButton(getString(R.string.ok)) { p0, p1 -> }
                    builder.show()
                }
                is NetworkState.Error -> swiperefresh.isRefreshing = false
                is NetworkState.Success -> swiperefresh.isRefreshing = false
                is NetworkState.Loading -> swiperefresh.isRefreshing = true
            }
        })
    }

}