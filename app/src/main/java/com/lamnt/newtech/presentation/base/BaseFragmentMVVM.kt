package com.lamnt.newtech.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lamnt.newtech.presentation.ui.dialog.LoadingDialog

abstract class BaseFragmentMVVM<B : ViewDataBinding, V : BaseViewModel> : Fragment() {
    private var loadingDialog: LoadingDialog? = null
    private lateinit var mViewDataBinding: B

    val binding: B get() = mViewDataBinding
    lateinit var viewModel: V

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModelClazz(): Class<V>

    protected abstract fun onViewReady(savedInstance: Bundle?)

    protected abstract fun initSubscriber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel(getViewModelClazz())
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()
        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(savedInstanceState)
        initSubscriber()
    }

    protected open fun <VM : ViewModel?> getViewModel(type: Class<VM>): VM {
        return ViewModelProvider(this, defaultViewModelProviderFactory).get(type)
    }

    fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(requireActivity())
        }
        loadingDialog?.show()
    }

    fun hideLoading() {
        loadingDialog?.run {
            if (isShowing) dismiss()
        }
    }
}