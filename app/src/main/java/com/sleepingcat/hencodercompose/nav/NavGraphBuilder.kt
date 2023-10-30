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
import com.sleepingcat.hencodercompose.NavRegistry
import com.sleepingcat.nav_plugin_runtime.NavData
import com.sleepingcat.nav_plugin_runtime.NavDestination

/**
 * @作者 志浩
 * @时间 2023/10/13 14:58
 * @描述
 */
object NavGraphBuilder {
    private val TAG = "NavGraphBuilder"
    private val navGroupMap = hashMapOf<String, NavGraph?>()
    private lateinit var topNavGraph: NavGraph
    private lateinit var graphNavigator: NavGraphNavigator

    fun build(controller: NavController, context: Context): NavGraph {
        // 1.构建navGraph对象
        val provider = controller.navigatorProvider
        graphNavigator = provider["navigation"]
        topNavGraph = graphNavigator.createDestination()
        NavRegistry.getList().forEach { navData ->
            val destination: androidx.navigation.NavDestination
            when (navData.type) {
                NavDestination.NavType.Fragment -> {
                    val navigator = provider.get<FragmentNavigator>("fragment")
                    destination = navigator.createDestination()
                    // 要设置了route之后才能设置id，原因看destination.route的注解
//                    destination.route = navData.route
                    destination.id = navData.route.hashCode()
                    destination.setClassName(navData.className)
                }

                NavDestination.NavType.Activity -> {
                    val navigator = provider.get<ActivityNavigator>("activity")
                    destination = navigator.createDestination()
//                    destination.route = navData.route
                    destination.id = navData.route.hashCode()
                    destination.setComponentName(ComponentName(context.packageName, navData.className))
                }

                NavDestination.NavType.Dialog -> {
                    val navigator = provider.get<DialogFragmentNavigator>("dialog")
                    destination = navigator.createDestination()
//                    destination.route = navData.route
                    destination.id = navData.route.hashCode()
                    destination.setClassName(navData.className)
                }

                else -> {
                    throw IllegalStateException("创建navGraph失败，不能用None类型")
                }
            }
            addDestination(navData, destination)
            inflateDeeplink(context, navData, destination)
        }
//        controller.setGraph(navGraph, null)
        return topNavGraph
    }

    private fun getNavGraph(navGraphRoute: String): NavGraph {
        val graph = navGroupMap[navGraphRoute]
        return if (graph == null) {
            val navGraph = graphNavigator.createDestination()
            navGraph.route = navGraphRoute
            navGraph.id = navGraphRoute.hashCode()
            navGroupMap[navGraphRoute] = navGraph
            navGraph
        } else {
            graph
        }
    }

    private fun addDestination(navData: NavData, destination: androidx.navigation.NavDestination) {
        if (navData.navGraphRoute.isEmpty()) {
            topNavGraph.addDestination(destination)
            if (navData.isStart) {
                topNavGraph.setStartDestination(navData.route.hashCode())
            }
        } else {
            val navGraph = getNavGraph(navData.navGraphRoute)
            navGraph.addDestination(destination)
            if (navData.isStart) {
                navGraph.setStartDestination(navData.route.hashCode())
            }
            topNavGraph.remove(navGraph)
            topNavGraph.addDestination(navGraph)

        }
    }

    private fun inflateDeeplink(context: Context, navData: NavData, destination: androidx.navigation.NavDestination) {
        if (navData.deeplink.isNotEmpty()) {
            val builder = NavDeepLink.Builder()
            builder.setUriPattern(navData.deeplink.replace(NavInflater.APPLICATION_ID_PLACEHOLDER, context.packageName))
            destination.addDeepLink(builder.build())
        }
    }
}