package com.sleepingcat.hencodercompose.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.hencodercompose.base.BaseFragment
import com.sleepingcat.hencodercompose.databinding.FragmentTagsBinding

/**
 * @作者 志浩
 * @时间 2023/9/27 15:33
 * @描述 TODO
 */
class TagsFragment : BaseFragment() {
    override val TAG = "TagsFragment"
    private lateinit var tagsBinding: FragmentTagsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "savedInstanceState = ${savedInstanceState}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        tagsBinding = FragmentTagsBinding.inflate(inflater, container, false)
        return tagsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tagsBinding.apply {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.navigate_to_user_fragment,null,NavOptions.Builder().setPopUpTo(R.id.homeFragment,inclusive = false,saveState = true).build())
            }
            btnPre.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putString("name", TAG)
    }

}