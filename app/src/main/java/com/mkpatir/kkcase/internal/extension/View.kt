package com.mkpatir.kkcase.internal.extension

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun ImageView.loadImageFromUrl(url: String?){
    url?.let {
        Glide.with(this.context.applicationContext).load(it).into(this)
    }
}

@BindingAdapter("circleImgUrl")
fun ImageView.loadCircleImageFromUrl(url: String?){
    url?.let {
        Glide.with(this.context.applicationContext).load(url).circleCrop().into(this)
    }
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}