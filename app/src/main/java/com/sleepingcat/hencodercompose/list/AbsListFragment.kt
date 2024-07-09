package com.sleepingcat.hencodercompose.list

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.hencodercompose.databinding.LayoutAbsListFragmentBinding
import com.sleepingcat.hencodercompose.model.Feed
import com.sleepingcat.lib_common.base.BaseFragment
import kotlinx.coroutines.launch
import setVisibility

open class AbsListFragment : BaseFragment<LayoutAbsListFragmentBinding>() {
    private lateinit var feedAdapter: FeedAdapter

    override fun initView() {
        super.initView()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.apply {
            listView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            listView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            feedAdapter = FeedAdapter()
            val contactAdapter = feedAdapter.withLoadStateFooter(FooterLoadStateAdapter())
            listView.adapter = contactAdapter
            refreshLayout.setColorSchemeColors(requireContext().getColor(R.color.color_theme))
            refreshLayout.setOnRefreshListener {
                feedAdapter.refresh()
            }
            lifecycleScope.launch {
                // 当数据有变化时会触发此回调
                feedAdapter.onPagesUpdatedFlow.collect {
                    val hasData = feedAdapter.itemCount > 0
                    refreshLayout.isRefreshing = !hasData
                    listView.setVisibility(hasData)
                    loadingStatus.setVisibility(!hasData)
                    if (!hasData) {
                        loadingStatus.showEmpty {
                            feedAdapter.retry()
                        }
                    }
                }
            }
        }
    }

    fun submitData(pagingData: PagingData<Feed>) {
        lifecycleScope.launch {
            feedAdapter.submitData(pagingData)
        }
    }
}