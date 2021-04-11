package com.example.itunes.util

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.itunes.callbacks.OnAdapterItemClickListener
import com.example.itunes.data.ItuneDto

@BindingAdapter("app:setImage")
fun ImageView.setImage(imageUrl: String) {
    Glide.with(context).load(imageUrl).into(this)
}

@BindingAdapter("app:onItemClicked", "app:setItem")
fun LinearLayout.onItemClicked(callback: OnAdapterItemClickListener, ituneDto: ItuneDto) {
    setOnClickListener {
        callback.onItemClicked(ituneDto)
    }
}