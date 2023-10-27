package com.sleepingcat.hencodercompose.nav

import android.content.ComponentName
import android.content.Context
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavInflater
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.get
import com.sleepingcat.nav_plugin_runtime.NavData
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/13 14:58
 * @描述 TODO
 */
object NavGraphBuilder {
    private val TAG = "NavGraphBuilder"

    fun build(controller: NavController, context: Context): NavGraph {
        // 1.构建navGraph对象
        val provider = controller.navigatorProvider
        val graphNavigator = provider.get<NavGraphNavigator>("navigation")
        val navGraph = graphNavigator.createDestination()

        NavRegistry.getList().forEach { navData ->
            when (navData.type) {
                NavDestination.NavType.Fragment -> {
                    val navigator = provider.get<FragmentNavigator>("fragment")
                    val destination = navigator.createDestination()
                    destination.id = navData.route.hashCode()
                    destination.setClassName(navData.className)
                    navGraph.addDestination(destination)
                    inflateDeeplink(context, navData, destination)
                }

                NavDestination.NavType.Activity -> {
                    val navigator = provider.get<ActivityNavigator>("activity")
                    val destination = navigator.createDestination()
                    destination.id = navData.route.hashCode()
                    destination.setComponentName(ComponentName(context.packageName, navData.className))
                    navGraph.addDestination(destination)
                    inflateDeeplink(context, navData, destination)
                }

                NavDestination.NavType.Dialog -> {
                    val navigator = provider.get<DialogFragmentNavigator>("dialog")
                    val destination = navigator.createDestination()
                    destination.id = navData.route.hashCode()
                    destination.setClassName(navData.className)
                    navGraph.addDestination(destination)
                    inflateDeeplink(context, navData, destination)
                }

                else -> {
                    throw IllegalStateException("创建navGraph失败，不能用None类型")
                }
            }
            if (navData.asStart) {
                navGraph.setStartDestination(navData.route.hashCode())
            }
        }
//        controller.setGraph(navGraph, null)
        return navGraph
    }

    private fun inflateDeeplink(context: Context, navData: NavData, destination: androidx.navigation.NavDestination) {
        if (navData.deeplink.isNotEmpty()) {
            val builder = NavDeepLink.Builder()
            builder.setUriPattern(navData.deeplink.replace(NavInflater.APPLICATION_ID_PLACEHOLDER, context.packageName))
            destination.addDeepLink(builder.build())
        }
    }
}