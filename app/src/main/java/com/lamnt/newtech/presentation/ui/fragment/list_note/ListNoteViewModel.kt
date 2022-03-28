package com.lamnt.newtech.presentation.ui.fragment.list_note

import androidx.lifecycle.viewModelScope
import com.lamnt.newtech.data.local.entity.Note
import com.lamnt.newtech.domain.usecases.ListNoteUseCase
import com.lamnt.newtech.presentation.base.BaseViewModel
import com.lamnt.newtech.presentation.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNoteViewModel @Inject constructor(private val listNoteUseCase: ListNoteUseCase) :
    BaseViewModel() {
    private val noteState = MutableStateFlow(Resource.success(listOf<Note>()))
    val notes = noteState.asStateFlow()

    fun getAllNote() {
        viewModelScope.launch {
            listNoteUseCase.getAllNote().collect {
                this@ListNoteViewModel.noteState.value = it
            }
        }
    }

    fun insertNote(note : Note) {
        viewModelScope.launch {
            listNoteUseCase.insertNote(note).collect {
                getAllNote()
            }
        }
    }
}