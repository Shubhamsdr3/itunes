package com.example.itunes.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.itunes.base.IBaseCustomView
import com.example.itunes.databinding.NetworkLoadingViewBinding

class NetworkLoadingView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defyStyle: Int = 0
) : IBaseCustomView<NetworkLoadingViewBinding>(context, attributeSet, defyStyle) {

    override fun getViewBinding(inflater: LayoutInflater): NetworkLoadingViewBinding {
        return NetworkLoadingViewBinding.inflate(inflater)
    }
}