package com.lamnt.newtech.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lamnt.newtech.data.local.entity.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun getAllNote(): List<Note>

    @Insert
    suspend fun insert(note: Note)
}