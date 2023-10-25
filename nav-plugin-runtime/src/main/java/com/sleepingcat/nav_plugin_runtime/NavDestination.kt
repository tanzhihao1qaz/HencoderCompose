package com.sleepingcat.nav_plugin_runtime

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class NavDestination(val type: NavType, val route: String, val asStart: Boolean = false, val deeplink: String = "") {
    enum class NavType {
        Fragment, Activity, Dialog, None
    }
}