package com.lamnt.newtech.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lamnt.newtech.data.local.dao.NoteDao
import com.lamnt.newtech.data.local.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}