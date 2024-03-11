package com.sleepingcat.hencodercompose.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * @作者 志浩
 * @时间 2024/2/29 15:25
 * @描述 TODO
 */
class LocalGsonConverterFactory : Converter.Factory() {
    private val TAG = "LocalGsonConverterFactory"
    private val gson = Gson()

    override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return LocalGsonResponseBodyConverter<Any >(gson, type)
    }

    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<out Annotation>, methodAnnotations: Array<out Annotation>, retrofit: Retrofit): Converter<*, RequestBody> {
        val adapter: TypeAdapter<*> = gson.getAdapter(TypeToken.get(type))
        return LocalGsonRequestBodyConverter(gson, adapter)
    }
}