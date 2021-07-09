package com.mkpatir.kkcase.ui.main

import com.mkpatir.kkcase.R
import com.mkpatir.kkcase.databinding.ActivityMainBinding
import com.mkpatir.kkcase.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    override fun setLayout(): Int = R.layout.activity_main

    override fun setViewModel(): Lazy<MainViewModel> = viewModel()

    override fun setupUI() {

    }
}