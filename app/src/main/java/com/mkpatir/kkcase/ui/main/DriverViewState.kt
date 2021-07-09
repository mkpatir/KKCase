package com.mkpatir.kkcase.ui.main

import android.content.Context
import androidx.core.content.ContextCompat
import com.mkpatir.kkcase.R
import com.mkpatir.kkcase.api.models.DriverData
import com.mkpatir.kkcase.internal.extension.orZero

data class DriverViewState(
    private val context: Context,
    private val data: DriverData,
    private val index: Int
) {

    fun getName() = data.name.orEmpty()

    fun getPoint() = data.point.orZero().toString()

    fun getFavoriteIcon() = if (data.isFavorite) ContextCompat.getDrawable(context,R.drawable.ic_star_full) else ContextCompat.getDrawable(context,R.drawable.ic_star_empty)

    fun getBackground() = when(index%3){
        0 -> ContextCompat.getDrawable(context,R.drawable.bg_rectangle_yellow)
        1 -> ContextCompat.getDrawable(context,R.drawable.bg_rectangle_thunder_bird)
        2 -> ContextCompat.getDrawable(context,R.drawable.bg_rectangle_gulf_blue)
        else -> ContextCompat.getDrawable(context,R.drawable.bg_rectangle_yellow)
    }

}