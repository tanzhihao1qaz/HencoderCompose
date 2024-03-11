package com.sleepingcat.hencodercompose.http

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @作者 志浩
 * @时间 2024/2/29 13:18
 * @描述 TODO
 */
interface IApiInterface {
    @GET("feeds/queryHotFeedsList")
    suspend fun getFeeds(
        @Query("feedId") feedId: Long = 0,
        @Query("feedType") feedType: String = "all",
        @Query("pageCount") pageCount: Int = 10,
        @Query("userId") userId: Int = 0
    ):ApiResult<JsonArray>

}