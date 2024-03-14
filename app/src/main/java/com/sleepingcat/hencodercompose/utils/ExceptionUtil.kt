package com.sleepingcat.hencodercompose.utils

import android.accounts.NetworkErrorException
import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 异常工具类
 * @author ssq
 */
object ExceptionUtil {

    /**
     * 处理异常，toast提示错误信息
     */
    fun catchException(e: Throwable) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                catchHttpException(e.code())
            }
            is SocketTimeoutException -> {

            }
            is UnknownHostException, is NetworkErrorException -> {

            }
            is MalformedJsonException, is JsonSyntaxException -> {

            }
            is InterruptedIOException -> {

            }
            else -> {

            }
        }
    }

    /**
     * 处理网络异常
     */
    fun catchHttpException(errorCode: Int) {

    }

}
