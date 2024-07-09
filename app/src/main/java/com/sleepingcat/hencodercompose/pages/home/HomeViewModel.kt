package com.sleepingcat.hencodercompose.pages.home

import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import com.sleepingcat.hencodercompose.ext.launchWithError
import com.sleepingcat.hencodercompose.http.ApiResult
import com.sleepingcat.hencodercompose.http.ApiService
import com.sleepingcat.hencodercompose.model.Feed
import com.sleepingcat.lib_common.base.BaseViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * @作者 志浩
 * @时间 2024/3/15 15:43
 * @描述 TODO
 */
class HomeViewModel : BaseViewModel() {
    private val TAG = "HomeViewModel"
    val hotFeeds = Pager(
        config = PagingConfig(pageSize = 10, initialLoadSize = 10, enablePlaceholders = false),
        pagingSourceFactory = {
            HomePagingSource()
        }).flow.cachedIn(viewModelScope)

    inner class HomePagingSource : PagingSource<Long, Feed>() {

        override fun getRefreshKey(state: PagingState<Long, Feed>): Long? {
            val handler = Handler(Looper.getMainLooper(), Handler.Callback {
                return@Callback true
            })
            handler.post {

            }
            return null
        }

        override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Feed> {
            viewModelScope.launch {
                async {  }.await()
            }
            val result = kotlin.runCatching {
                ApiService.getService().getFeeds(feedId = params.key ?: 0L)
            }
            val apiResult = result.getOrDefault(ApiResult())
            if (apiResult.success && apiResult.body?.isNotEmpty() == true) {
                return LoadResult.Page(apiResult.body!!, null, apiResult.body!!.last().id)
            }
            return if (params.key == null) LoadResult.Page(arrayListOf(), null, 0) else LoadResult.Error(RuntimeException("No more data to refresh"))
        }

    }
}