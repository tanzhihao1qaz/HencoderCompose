package com.sleepingcat.ft_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sleepingcat.ft_home.databinding.FragmentOtherBinding
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/10 21:33
 * @描述 TODO
 */
@NavDestination(route = "other", type = NavDestination.NavType.Fragment)
class OtherFragment : BaseFragment() {
    override val TAG = "OtherFragment"
    private lateinit var otherBinding: FragmentOtherBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        otherBinding = FragmentOtherBinding.inflate(inflater, container, false)
        return otherBinding.root
    }

}