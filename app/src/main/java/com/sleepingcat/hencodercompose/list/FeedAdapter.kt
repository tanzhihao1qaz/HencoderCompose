package com.sleepingcat.hencodercompose.list

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sleepingcat.hencodercompose.model.Feed

class FeedAdapter(diffCallback: DiffUtil.ItemCallback<Feed>) :PagingDataAdapter<Feed,FeedAdapter.FeedViewHolder>(diffCallback) {

    inner class  FeedViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

    }
}