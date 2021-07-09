package com.mkpatir.kkcase.ui.main

import com.mkpatir.kkcase.R
import com.mkpatir.kkcase.databinding.ActivityMainBinding
import com.mkpatir.kkcase.ui.base.BaseActivity
import com.mkpatir.kkcase.ui.base.Navigator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    private val driverAdapter = DriverAdapter()

    override fun setLayout(): Int = R.layout.activity_main

    override fun setViewModel(): Lazy<MainViewModel> = viewModel()

    override fun setupUI() {
        getDataBinding().rvDrivers.adapter = driverAdapter
        initObservers()
        initListeners()
    }

    private fun initObservers(){
        getViewModel().apply {
            driversLiveData.observe(this@MainActivity, {
                driverAdapter.updateAdapter(it)
            })
        }
    }

    private fun initListeners(){
        getDataBinding().apply {
            driverAdapter.favoriteClick = {
                getViewModel().addOrRemoveFavorite(it)
            }
            driverAdapter.onItemClick = {
                Navigator.navigateToNext(this@MainActivity, it)
            }
            buttonDecreasing.setOnClickListener {
                getViewModel().sortDrivers(MainViewModel.Sort.DECREASING)
                rvDrivers.smoothScrollToPosition(0)
            }
            buttonIncreasing.setOnClickListener {
                getViewModel().sortDrivers(MainViewModel.Sort.INCREASING)
                rvDrivers.smoothScrollToPosition(0)
            }
        }
    }
}