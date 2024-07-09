package com.sleepingcat.hencodercompose.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.hencodercompose.databinding.LayoutAbsListLoadingFooterBinding

/**
 * @作者 志浩
 * @时间 2024/3/15 15:22
 * @描述 TODO
 */
class FooterLoadStateAdapter : LoadStateAdapter<FooterLoadStateAdapter.LoadStateViewHolder>() {
    private val TAG = "FeedLoadStateAdapter"

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        // 根据加载状态显示footer
        when(loadState){
            is LoadState.Loading -> {
                holder.binding.apply {
                    text.setText(R.string.abs_list_loading_footer_loading)
                    loading.show()
                }
            }
            is LoadState.Error -> {
                holder.binding.apply {
                    text.setText(R.string.abs_list_loading_footer_error)
                }
            }
            else -> {
                // 默认状态
                holder.binding.apply {
                    loading.hide()
                    loading.postOnAnimation { loading.visibility = View.GONE }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val inflate = LayoutAbsListLoadingFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(inflate)
    }

    inner class LoadStateViewHolder(val binding: LayoutAbsListLoadingFooterBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}