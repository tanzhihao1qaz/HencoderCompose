package com.sleepingcat.ft_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sleepingcat.ft_home.databinding.FragmentOtherTextBinding
import com.sleepingcat.lib_common.TestBaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2024/9/5 22:12
 * @描述 TODO
 */
@NavDestination(route = "other", type = NavDestination.NavType.Fragment)
class OtherTestFragment : TestBaseFragment() {
    override val TAG = "OtherTestFragment"
    private lateinit var binding: FragmentOtherTextBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOtherTextBinding.inflate(inflater, container, false)
        return binding.root
    }
}