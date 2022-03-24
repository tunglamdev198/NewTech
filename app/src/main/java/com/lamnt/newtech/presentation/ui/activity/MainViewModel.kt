package com.lamnt.newtech.presentation.ui.activity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _countState = MutableStateFlow(0)

    val countState: StateFlow<Int> = _countState

    fun incrementCount() {
        _countState.value++
    }

    fun decrementCount() {
        _countState.value--
    }
}