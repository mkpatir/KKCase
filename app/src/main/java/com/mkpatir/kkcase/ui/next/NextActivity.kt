package com.mkpatir.kkcase.ui.next

import android.content.Context
import android.content.Intent
import com.mkpatir.kkcase.R
import com.mkpatir.kkcase.databinding.ActivityNextBinding
import com.mkpatir.kkcase.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NextActivity: BaseActivity<ActivityNextBinding,NextViewModel>() {

    companion object {
        fun newIntent(context: Context) = Intent(context,NextActivity::class.java)
    }

    override fun setLayout(): Int = R.layout.activity_next

    override fun setViewModel(): Lazy<NextViewModel> = viewModel()

    override fun setupUI() {

    }
}