package com.sleepingcat.ft_mine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sleepingcat.ft_mine.databinding.FragmentMineBinding
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/30 20:39
 * @描述 TODO
 */
@NavDestination(type = NavDestination.NavType.Fragment, route = "mine", deeplink = "test://com.techme.jetpack/user?phone={phone}")
class MineFragment : BaseFragment() {
    override val TAG = "MineFragment"

    private lateinit var mineBinding: FragmentMineBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mineBinding = FragmentMineBinding.inflate(inflater, container, false)
        return mineBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val phone = arguments?.getString("phone")
        Log.d(TAG, "phone = $phone")
    }
}