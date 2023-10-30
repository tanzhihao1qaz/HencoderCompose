package com.sleepingcat.hencodercompose.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.hencodercompose.databinding.FragmentHomeBinding
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/9/27 15:33
 * @描述 TODO
 */
@NavDestination(route = "home", type = NavDestination.NavType.Fragment, isStart = true)
class HomeFragment : BaseFragment() {
    override val TAG = "HomeFragment"
    private lateinit var homeBinding: FragmentHomeBinding
    private var flag = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding.apply {
            btnNext.setOnClickListener {
                /*if (!flag){
                    findNavController().navigate(R.id.navigate_to_category_fragment)
                    flag = true
                    Log.d("MainActivity","第一次")
                }else {
                    findNavController().navigate(R.id.navigate_to_category_fragment,null,NavOptions.Builder().setRestoreState(true).build())
                    Log.d("MainActivity","第二次")
                }*/
//                val build = NavDeepLinkRequest.Builder.fromUri("test://com.techme.jetpack/user?phone=123456".toUri()).build()
//                findNavController().navigate(build)
                findNavController().navigate("tags".hashCode())
            }
            btnPre.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}