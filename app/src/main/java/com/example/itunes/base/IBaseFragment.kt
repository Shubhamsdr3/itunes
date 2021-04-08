package com.example.itunes.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class IBaseFragment<VB : ViewBinding, VM : IBaseViewModel> : Fragment() {

    protected abstract val viewModel: VM

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater)
        setupView()
        setupObserver()
        setupListener()
        return binding.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater): VB

    fun goBack() {
        requireActivity().onBackPressed()
    }

    protected abstract fun setupObserver()

    protected abstract fun setupView()

    protected open fun setupListener() {}
}