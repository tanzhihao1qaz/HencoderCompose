package com.sleepingcat.ft_scene.vm

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

/**
 * @作者 志浩
 * @时间 2023/10/30 17:29
 * @描述 TODO
 */
class SceneVm : ViewModel() {
    private val TAG = "SceneVm"

    var num = 0

    fun addNum() {
        num++
    }
}