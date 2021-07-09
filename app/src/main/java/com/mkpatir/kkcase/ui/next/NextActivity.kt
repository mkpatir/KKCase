package com.mkpatir.kkcase.ui.next

import android.content.Context
import android.content.Intent
import com.mkpatir.kkcase.R
import com.mkpatir.kkcase.api.models.DriverData
import com.mkpatir.kkcase.databinding.ActivityNextBinding
import com.mkpatir.kkcase.internal.extension.orZero
import com.mkpatir.kkcase.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NextActivity: BaseActivity<ActivityNextBinding,NextViewModel>() {

    companion object {
        private const val DRIVER_DATA = "DRIVER_DATA"

        fun newIntent(context: Context,driverData: DriverData) = Intent(context,NextActivity::class.java).apply {
            putExtra(DRIVER_DATA,driverData)
        }
    }

    override fun setLayout(): Int = R.layout.activity_next

    override fun setViewModel(): Lazy<NextViewModel> = viewModel()

    override fun setupUI() {
        handleIntent()
        initObservers()
    }

    private fun handleIntent(){
        intent.getParcelableExtra<DriverData>(DRIVER_DATA)?.let {
            getDataBinding().driverData = it
            getViewModel().getDriverDetail(it.id.orZero())
        }
    }

    private fun initObservers(){
        getViewModel().apply {
            driverDetailLiveData.observe(this@NextActivity, {
                getDataBinding().detailData = it
            })
        }
    }
}