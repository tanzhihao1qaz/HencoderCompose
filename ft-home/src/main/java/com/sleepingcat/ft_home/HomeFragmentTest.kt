package com.sleepingcat.ft_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sleepingcat.ft_home.databinding.FragmentHomeBinding
import com.sleepingcat.lib_common.TestBaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/10 21:33
 * @描述 TODO
 */
@NavDestination(route = "home", type = NavDestination.NavType.Fragment, isStart = true)
class HomeFragmentTest : TestBaseFragment() {
    override val TAG = "HomeFragment"
    private lateinit var homeFragmentBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        homeFragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeFragmentBinding.apply {
            btn.setOnClickListener {
                findNavController().navigate("sceneGraph".hashCode())
            }
        }
    }

}