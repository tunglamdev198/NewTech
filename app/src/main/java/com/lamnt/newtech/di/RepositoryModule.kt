package com.lamnt.newtech.di

import com.lamnt.newtech.domain.repository.NoteRepositoryImpl
import com.lamnt.newtech.presentation.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}