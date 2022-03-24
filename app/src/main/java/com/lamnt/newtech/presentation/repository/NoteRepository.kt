package com.lamnt.newtech.presentation.repository

import com.lamnt.newtech.data.local.entity.Note

interface NoteRepository {
    suspend fun getAllNote(): List<Note>
    suspend fun insertNote(note : Note)
}