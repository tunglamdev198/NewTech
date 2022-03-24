package com.lamnt.newtech.domain.repository

import com.lamnt.newtech.data.local.dao.NoteDao
import com.lamnt.newtech.data.local.entity.Note
import com.lamnt.newtech.presentation.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun getAllNote() = noteDao.getAllNote()
    override suspend fun insertNote(note: Note) = noteDao.insert(note)
}