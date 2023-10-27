package com.sleepingcat.hencodercompose.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.lib_common.BaseFragment
import com.sleepingcat.hencodercompose.databinding.FragmentCategoryBinding

/**
 * @作者 志浩
 * @时间 2023/9/27 15:33
 * @描述 TODO
 */
class CategoryFragment : BaseFragment() {
    override val TAG = "CategoryFragment"
    private lateinit var categoryBinding: FragmentCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"savedInstanceState = ${savedInstanceState}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        categoryBinding = FragmentCategoryBinding.inflate(inflater, container, false)
        return categoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryBinding.apply {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.navigate_to_tags_fragment)
            }
            btnPre.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putString("name",TAG)
    }
}