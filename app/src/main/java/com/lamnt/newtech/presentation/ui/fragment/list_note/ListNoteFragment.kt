package com.lamnt.newtech.presentation.ui.fragment.list_note

import android.os.Bundle
import com.lamnt.newtech.R
import com.lamnt.newtech.data.local.entity.Note
import com.lamnt.newtech.databinding.FragmentListNoteBinding
import com.lamnt.newtech.extensions.click
import com.lamnt.newtech.extensions.handleData
import com.lamnt.newtech.extensions.setupVertical
import com.lamnt.newtech.presentation.base.BaseFragmentMVVM
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ListNoteFragment : BaseFragmentMVVM<FragmentListNoteBinding, ListNoteViewModel>() {
    private val noteAdapter by lazy {
        ListNoteAdapter()
    }

    override fun getLayoutId(): Int = R.layout.fragment_list_note
    override fun getViewModelClazz() = ListNoteViewModel::class.java

    override fun onViewReady(savedInstance: Bundle?) {
        binding.rvNotes.setupVertical(noteAdapter)
        viewModel.getAllNote()
        binding.btnAdd.click {
            viewModel.insertNote(
                Note(
                    title = UUID.randomUUID().toString(),
                    content = UUID.randomUUID().toString()
                )
            )
        }
    }

    override fun initSubscriber() {
        handleData(viewModel.notes) {
            noteAdapter.notifyDataChanged(it)
        }
    }

}