package com.example.itunes.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding

abstract class IBaseCustomView<VB : ViewBinding> : FrameLayout {

    lateinit var binding: VB
    
    constructor(context: Context) : super(context) {
        initialize(null)
    }

    constructor(context: Context, attributeSet: AttributeSet? = null) : super(context, attributeSet) {
        initialize(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet? = null, defyStyle: Int = 0) : super(context, attributeSet, defyStyle) {
        initialize(attributeSet)
    }

    private fun initialize(attributeSet: AttributeSet?) {
        binding = getViewBinding(LayoutInflater.from(context))
        this.addView(binding.root)
        setupView(attributeSet)
        setupListener()
    }

    abstract fun getViewBinding(inflater: LayoutInflater): VB

    protected open fun setupView(attributeSet: AttributeSet?){}

    protected open fun setupListener() {}
}