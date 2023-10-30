package com.sleepingcat.ft_scene

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.sleepingcat.ft_scene.databinding.FragmentSceneBinding
import com.sleepingcat.ft_scene.vm.SceneVm
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/30 17:22
 * @描述 TODO
 */
@NavDestination(route = "scene1", type = NavDestination.NavType.Fragment, isStart = true, navGraphRoute = "sceneGraph")
class SceneFragment : BaseFragment() {
    override val TAG = "SceneFragment"
    private val vm by navGraphViewModels<SceneVm>("sceneGraph".hashCode())
    private lateinit var sceneBinding: FragmentSceneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        sceneBinding = FragmentSceneBinding.inflate(inflater, container, false)
        return sceneBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sceneBinding.apply {
            btnValue.setOnClickListener {
                Toast.makeText(requireContext(), vm.num.toString(), Toast.LENGTH_SHORT).show()
            }
            btn.setOnClickListener {
                findNavController().navigate("scene2".hashCode())
            }
        }
    }
}