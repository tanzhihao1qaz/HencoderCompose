package com.sleepingcat.lib_common.base

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.sleepingcat.lib_common.bus.SharedFlowBus
import com.sleepingcat.lib_common.bus.event.LoadingEvent
import com.sleepingcat.lib_common.utils.ViewBindingUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    private var isFragmentViewInit = false

    open val vm by viewModels<BaseViewModel>()
//    open val loading by lazy { LoadingDialog() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = ViewBindingUtil.inflateWithGeneric<VB>(this, inflater, container, false).apply {
                if (root.background == null) root.setBackgroundColor(Color.WHITE)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initObserver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("currentFragment - onCreate", this.javaClass.name)
    }

    override fun onResume() {
        super.onResume()
        Log.d("currentFragment - onResume", this.javaClass.name)
    }

    open fun initView() {

    }

    open fun initData() {

    }

    open fun refreshData() {

    }

    open fun initObserver() {
        SharedFlowBus.onSticky(LoadingEvent::class.java).observe(viewLifecycleOwner) {
            if (it.show) showLoading(it.text) else dismissLoading()
        }
    }

    fun showLoading(str: String? = null, drawable: Drawable? = null) {
        /*if (!loading.isAdded) {
            loading.showLoading(parentFragmentManager, str, drawable)
        }*/
    }

    fun dismissLoading() {
        /*if (loading.isAdded) {
            loading.dismissLoading()
        } else {
            // 防止showLoading之后马上dismiss引起的无法隐藏loading问题（那时fragment还没来得及依附到Activity，所以isAdded = false）
            lifecycleScope.launch {
                delay(100)
                if (loading.isAdded) {
                    loading.dismissLoading()
                }
            }
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("currentFragment - onDestory", this.javaClass.name)
        _binding = null
    }
}