package com.sleepingcat.hencodercompose.http

/**
 * @作者 志浩
 * @时间 2024/2/29 13:20
 * @描述 TODO
 */
class ApiResult<T> {
    private val TAG = "ApiResult"
    var status = 0
    var errMsg = ""
    val success
        get() = status == 200
    var body: T? = null
}