package com.mkpatir.kkcase.ui.base

import android.content.Context
import com.mkpatir.kkcase.api.models.DriverData
import com.mkpatir.kkcase.ui.next.NextActivity

object Navigator {

    fun navigateToNext(context: Context, driverData: DriverData) {
        context.startActivity(NextActivity.newIntent(context,driverData))
    }

}