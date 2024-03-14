package com.sleepingcat.lib_common.base

import androidx.lifecycle.ViewModel
import com.sleepingcat.lib_common.bus.SharedFlowBus
import com.sleepingcat.lib_common.bus.event.LoadingEvent


open class BaseViewModel: ViewModel() {

    fun showLoading() {
        SharedFlowBus.withSticky(LoadingEvent::class.java).tryEmit(LoadingEvent(true))
    }

    fun dismissLoading() {
        SharedFlowBus.withSticky(LoadingEvent::class.java).tryEmit(LoadingEvent(false))
    }

}