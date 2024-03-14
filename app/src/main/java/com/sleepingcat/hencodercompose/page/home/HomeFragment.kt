package com.sleepingcat.hencodercompose.page.home

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.sleepingcat.hencodercompose.databinding.FragmentHomeBinding
import com.sleepingcat.hencodercompose.ext.launchWithError
import com.sleepingcat.hencodercompose.http.ApiService
import com.sleepingcat.lib_common.base.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination
import kotlinx.coroutines.launch

@NavDestination(type = NavDestination.NavType.Fragment, route = "home", isStart = true)
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initView() {
        super.initView()
        lifecycleScope.launchWithError({
            ApiService.getService().getFeeds()
        }, onError = {
            Log.e("异常", it.message.toString())
        })
    }
}