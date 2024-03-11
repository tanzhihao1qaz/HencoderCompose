package com.sleepingcat.hencodercompose.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @作者 志浩
 * @时间 2024/2/29 13:11
 * @描述 TODO
 */
object ApiService {
    private val TAG = "ApiService"

    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl("http://8.136.122.222/jetpack/")
        .client(okHttpClient)
        .addConverterFactory(LocalGsonConverterFactory()) // 对发起请求是的request以及请求返回的数据做转换
        .build()

    fun getService():IApiInterface {
        return retrofit.create(IApiInterface::class.java)
    }
}