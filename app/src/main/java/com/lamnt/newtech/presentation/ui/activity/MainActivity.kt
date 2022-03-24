package com.lamnt.newtech.presentation.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lamnt.newtech.R
import com.lamnt.newtech.databinding.ActivityMainBinding
import com.lamnt.newtech.presentation.ui.fragment.list_note.ListNoteFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ListNoteFragment())
            .commit()
    }
}