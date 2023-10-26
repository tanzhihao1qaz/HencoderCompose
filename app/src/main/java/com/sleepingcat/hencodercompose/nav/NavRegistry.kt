// 此文件是自动生成，不用编辑它
package com.sleepingcat.hencodercompose.nav

import com.sleepingcat.nav_plugin_runtime.NavData
import com.sleepingcat.nav_plugin_runtime.NavDestination.NavType.Activity
import com.sleepingcat.nav_plugin_runtime.NavDestination.NavType.Dialog
import com.sleepingcat.nav_plugin_runtime.NavDestination.NavType.Fragment
import com.sleepingcat.nav_plugin_runtime.NavDestination.NavType.None
import kotlin.collections.ArrayList
import kotlin.collections.List

public object NavRegistry {
    private val navList: ArrayList<NavData> = ArrayList<NavData>()


    init {
        navList.add(
            NavData(
                type = Fragment, route = "other", className =
                "com.sleepingcat.ft_home.OtherFragment", asStart = false, deeplink = ""
            )
        )
        navList.add(
            NavData(
                type = Fragment, route = "home", className =
                "com.sleepingcat.hencodercompose.fragment.HomeFragment", asStart = false, deeplink = ""
            )
        )

    }

    public fun getList(): List<NavData> {
        val list = ArrayList<NavData>()
        list.addAll(navList)
        return list

    }
}
