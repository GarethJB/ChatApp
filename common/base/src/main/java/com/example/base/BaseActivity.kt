package com.example.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<Binding : ViewDataBinding> : AppCompatActivity() {

    private val TAG = BaseActivity::class.java.simpleName

    protected val binding: Binding by lazy { createBinding() }

    protected abstract fun createBinding(): Binding

    protected open fun initActivity(savedInstanceState: Bundle?) = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}