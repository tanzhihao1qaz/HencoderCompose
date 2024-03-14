package com.sleepingcat.hencodercompose.page.user

import com.sleepingcat.hencodercompose.databinding.FragmentUserBinding
import com.sleepingcat.lib_common.base.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

@NavDestination(type = NavDestination.NavType.Fragment, route = "user")
class UserFragment:BaseFragment<FragmentUserBinding>() {
}