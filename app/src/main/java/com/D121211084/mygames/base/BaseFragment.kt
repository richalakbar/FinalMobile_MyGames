package com.D121211084.mygames.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.D121211084.mygames.utils.AppProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment(@LayoutRes layoutId: Int): Fragment(layoutId) {

    open fun initData() {}
    open fun initUI() {
        setupProgress()
    }
    open fun initAction() {}
    open fun initObserver() {}

    lateinit var progress : AppProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initAction()
        initUI()
        initObserver()

    }

    private fun setupProgress() {
        progress = AppProgressDialog(requireContext())
        progress.setCancelable(false)
        progress.setCanceledOnTouchOutside(false)
    }

}