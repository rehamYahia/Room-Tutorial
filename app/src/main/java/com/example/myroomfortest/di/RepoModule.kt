package com.example.myroomfortest.di

import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.repo.PersonRepo
import com.example.myroomfortest.repo.PersonRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideRepo(personDao: PersonDao):PersonRepo{
        return PersonRepoImp(personDao)
    }
}