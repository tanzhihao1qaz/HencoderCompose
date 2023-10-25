package com.sleepingcat.hencodercompose.nav

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphNavigator
import androidx.navigation.get

/**
 * @作者 志浩
 * @时间 2023/10/13 14:58
 * @描述 TODO
 */
object NavGraphBuilder {
    private val TAG = "NavGraphBuilder"

    fun build(controller: NavController, context: Context) {
        // 1.构建navGraph对象
        val provider = controller.navigatorProvider
        val graphNavigator = provider.get<NavGraphNavigator>("navigation")
    }
}