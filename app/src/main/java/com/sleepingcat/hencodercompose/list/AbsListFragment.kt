package com.sleepingcat.hencodercompose.list

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sleepingcat.hencodercompose.databinding.LayoutAbsListFragmentBinding
import com.sleepingcat.lib_common.base.BaseFragment

class AbsListFragment : BaseFragment<LayoutAbsListFragmentBinding>() {
    override fun initView() {
        super.initView()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.apply {
            listView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            listView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }
}