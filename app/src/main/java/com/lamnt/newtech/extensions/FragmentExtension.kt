package com.lamnt.newtech.extensions

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.lamnt.newtech.presentation.base.BaseFragmentMVVM
import com.lamnt.newtech.presentation.model.Resource
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> BaseFragmentMVVM<*, *>.handleData(
    stateFlow: StateFlow<Resource<T>>,
    onError: (String?) -> Unit = {},
    onSuccess: (T) -> Unit
) {
    lifecycleScope.launch {
        stateFlow.collect { value ->
            when (value.status) {
                Resource.Status.LOADING -> showLoading()
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    value.data?.let { onSuccess(it) }
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                    Toast.makeText(requireActivity(), value.message, Toast.LENGTH_SHORT).show()
                    onError(value.message)
                }
                else -> {}
            }
        }
    }
}