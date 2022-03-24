package com.lamnt.newtech.presentation.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.lamnt.newtech.databinding.LayoutLoadingBinding

class LoadingDialog(context: Context) : Dialog(context) {
    lateinit var binding: LayoutLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoadingBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
    }
}