package com.sleepingcat.hencodercompose.http

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonToken
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @作者 志浩
 * @时间 2024/2/29 15:47
 * @描述 TODO
 */
class LocalGsonResponseBodyConverter<T>(private val gson: Gson, private val type: Type) : Converter<ResponseBody, ApiResult<T>> {
    private val TAG = "LocalGsonResponseBodyConverter"

    override fun convert(value: ResponseBody): ApiResult<T> {
        return value.use {
            if (type !is ParameterizedType || !ApiResult::class.java.isAssignableFrom((type as ParameterizedType).rawType as Class<*>)) {
                throw java.lang.RuntimeException("return type must be ApiResult<*>")
            }
            val apiResult = ApiResult<T>()
            val response = JSONObject(value.string())
            apiResult.status = response.optInt("status")
            apiResult.errMsg = response.optString("message")
            val data1 : JSONObject? = response.optJSONObject("data")
            if (data1 != null) {
                val data2:String? = data1.optString("data")
                if (data2 != null) {
                    val parameterizedType = type as ParameterizedType // type对应的是ApiResult<T>
                    val argumentType = parameterizedType.actualTypeArguments[0] // 第0个表示ApiResult<T>的第一个泛型，因为ApiResult<T>只有一个泛型，所以直接获取第0个
                    apiResult.body = gson.fromJson(data2,argumentType)
                }
            }
            apiResult
        }
    }
}