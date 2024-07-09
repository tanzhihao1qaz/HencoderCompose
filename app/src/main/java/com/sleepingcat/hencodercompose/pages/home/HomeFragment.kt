package com.sleepingcat.hencodercompose.pages.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sleepingcat.hencodercompose.ext.launchWithError
import com.sleepingcat.hencodercompose.http.ApiService
import com.sleepingcat.hencodercompose.list.AbsListFragment
import com.sleepingcat.lib_common.base.BaseViewModel
import com.sleepingcat.nav_plugin_runtime.NavDestination
import kotlinx.coroutines.launch

@NavDestination(type = NavDestination.NavType.Fragment, route = "home", isStart = true)
class HomeFragment : AbsListFragment() {
    override val vm by viewModels<HomeViewModel>()

    override fun initView() {
        super.initView()
        lifecycleScope.launch {
            vm.hotFeeds.collect {
                submitData(it)
            }
        }
    }
}