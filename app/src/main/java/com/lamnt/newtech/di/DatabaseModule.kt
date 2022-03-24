package com.lamnt.newtech.di

import android.content.Context
import androidx.room.Room
import com.lamnt.newtech.data.local.AppDatabase
import com.lamnt.newtech.data.local.dao.NoteDao
import com.lamnt.newtech.domain.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao = appDatabase.noteDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}