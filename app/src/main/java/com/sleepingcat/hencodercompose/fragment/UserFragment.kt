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
import com.sleepingcat.hencodercompose.databinding.FragmentUserBinding

/**
 * @作者 志浩
 * @时间 2023/9/27 15:33
 * @描述 TODO
 */
class UserFragment : BaseFragment() {
    override val TAG = "UserFragment"
    private lateinit var userBinding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        userBinding = FragmentUserBinding.inflate(inflater, container, false)
        arguments?.keySet()?.forEach {
            Log.d(TAG,"key = ${it}; value = ${arguments?.getString(it)}")
        }
        return userBinding.root
    }

    // home -> category -> tags -> user
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userBinding.apply {
            btnPre.setOnClickListener {
                findNavController().navigate(R.id.categoryFragment,null,NavOptions.Builder().setRestoreState(true).build())
            }
            btnPreRoot.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}