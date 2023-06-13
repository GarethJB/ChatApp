package com.example.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(
    private val app: Application
) : AndroidViewModel(app) {

    protected val appContext: Context get() = app.applicationContext

}