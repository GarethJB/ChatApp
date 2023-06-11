package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment() {

    private var _binding: Binding? = null

    protected val binding get() = _binding!!

    protected open fun initBinding() = Unit

    protected abstract fun createFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = createFragmentBinding(inflater, container).apply {
        lifecycleOwner = viewLifecycleOwner
        _binding = this
        initBinding()
    }.root



}