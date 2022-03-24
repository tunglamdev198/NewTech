package com.lamnt.newtech.domain.usecases

import com.lamnt.newtech.data.local.entity.Note
import com.lamnt.newtech.presentation.repository.NoteRepository
import javax.inject.Inject

class ListNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) :
    BaseUseCase() {
    suspend fun getAllNote() = handle { noteRepository.getAllNote() }
    suspend fun insertNote(note : Note) = handle { noteRepository.insertNote(note) }
}