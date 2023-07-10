package com.example.myroomfortest.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.room_builder.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomBuilder(application: Application): PersonDatabase
    {
        return  Room.databaseBuilder(application , PersonDatabase::class.java , "personDatabase")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(personDatabase: PersonDatabase):PersonDao{
        return personDatabase.getDao()
    }
}