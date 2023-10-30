package com.sleepingcat.ft_scene

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.sleepingcat.ft_scene.databinding.FragmentScene2Binding
import com.sleepingcat.ft_scene.vm.SceneVm
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/30 17:26
 * @描述 TODO
 */
@NavDestination(route = "scene2", type = NavDestination.NavType.Fragment, navGraphRoute = "sceneGraph")
class Scene2Fragment : BaseFragment() {
    override val TAG = "Scene2Fragment"
    private val vm by navGraphViewModels<SceneVm>("sceneGraph".hashCode())
    private lateinit var scene2Binding: FragmentScene2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        scene2Binding = FragmentScene2Binding.inflate(inflater, container, false)
        return scene2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scene2Binding.apply {
            btnChange.setOnClickListener {
                vm.addNum()
            }
            btn.setOnClickListener {
                val deeplink = NavDeepLinkRequest.Builder
                    .fromUri("test://com.techme.jetpack/user?phone=123456".toUri())
                    .build()
                findNavController().navigate(deeplink)
//                findNavController().navigate("mine".hashCode())
            }
        }
    }
}