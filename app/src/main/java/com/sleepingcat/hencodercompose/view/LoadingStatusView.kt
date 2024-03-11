package com.sleepingcat.hencodercompose.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import com.sleepingcat.hencodercompose.databinding.LayoutLoadingStatusViewBinding

/**
 * @作者 志浩
 * @时间 2024/2/29 12:20
 * @描述 TODO
 */
class LoadingStatusView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle) {
    private val TAG = "LoadingStatusView"

    private val binding = LayoutLoadingStatusViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER
        binding.loading.show() // 启动进度条，让他动起来
    }

    fun showEmpty(@DrawableRes iconRes: Int? = null, text: String? = null, retry: OnClickListener? = null) {
        binding.loading.hide()
        binding.emptyLayout.visibility = View.VISIBLE
        iconRes?.let {
            binding.emptyIcon.setImageResource(it)
        }
        text?.let {
            binding.emptyText.text = text
            binding.emptyText.visibility = View.VISIBLE
        }
        retry?.let {
            binding.emptyAction.setOnClickListener(it)
            binding.emptyAction.visibility = View.VISIBLE
        }
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        if (visibility != View.VISIBLE){
            binding.loading.hide()
        }
    }
}