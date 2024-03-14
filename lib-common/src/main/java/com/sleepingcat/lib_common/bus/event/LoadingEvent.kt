package com.sleepingcat.lib_common.bus.event

data class LoadingEvent(
    val show: Boolean,
    val type: LoadingType = LoadingType.LOADING,
    val text: String? = null,
)

enum class LoadingType {
    LOADING,
    SUCCESS,
    FAIL
}