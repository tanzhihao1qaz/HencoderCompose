package com.sleepingcat.hencodercompose.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @作者 志浩
 * @时间 2023/9/27 15:42
 * @描述 TODO
 */
abstract class BaseFragment : Fragment() {
    private val baseTag = "fragmentLife"
    abstract val TAG: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(baseTag,"${TAG}-onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(baseTag,"${TAG}-onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(baseTag,"${TAG}-onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        Log.d(baseTag,"${TAG}-onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(baseTag,"${TAG}-onPause")
        super.onPause()
    }

    override fun onDestroyView() {
        Log.d(baseTag,"${TAG}-onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(baseTag,"${TAG}-onDestroy")
        super.onDestroy()
    }
}