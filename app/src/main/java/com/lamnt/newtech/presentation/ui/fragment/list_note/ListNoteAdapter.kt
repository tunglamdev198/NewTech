package com.lamnt.newtech.presentation.ui.fragment.list_note

import com.lamnt.newtech.R
import com.lamnt.newtech.data.local.entity.Note
import com.lamnt.newtech.databinding.ItemNoteBinding
import com.lamnt.newtech.presentation.base.BaseAdapter

class ListNoteAdapter : BaseAdapter<Note, ItemNoteBinding>() {
    override val itemLayout: Int
        get() = R.layout.item_note

    override fun bind(binding: ItemNoteBinding, data: Note, position: Int) {
        binding.txtTitle.text = "Title: ${data.title}"
        binding.txtContent.text = "Content: ${data.content}"
    }
}