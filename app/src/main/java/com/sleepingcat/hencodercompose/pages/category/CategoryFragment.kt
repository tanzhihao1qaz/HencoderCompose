package com.sleepingcat.hencodercompose.pages.category

import com.sleepingcat.hencodercompose.databinding.FragmentCategoryBinding
import com.sleepingcat.lib_common.base.BaseFragment
import com.sleepingcat.nav_plugin_runtime.NavDestination

@NavDestination(type = NavDestination.NavType.Fragment, route = "category")
class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {
}