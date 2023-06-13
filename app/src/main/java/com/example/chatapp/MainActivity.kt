package com.example.chatapp


import com.example.base.BaseActivity
import com.example.chatapp.databinding.ActivityMainBinding
import com.example.chatapp.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun createBinding() = ActivityMainBinding.inflate(layoutInflater)

    private var homeFragment: HomeFragment? = null


    private fun addHomeFragment() {
        homeFragment = HomeFragment()
    }


}