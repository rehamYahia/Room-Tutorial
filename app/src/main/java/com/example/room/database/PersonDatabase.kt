package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.dao.PersonDao
import com.example.room.entities.Person

@Database(entities = [Person::class] , exportSchema = false , version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun getDao():PersonDao

    companion object{
        @Volatile
        private var INSTANCE : PersonDatabase ?= null

        fun getInstance(context:Context):PersonDatabase{
            val temp = INSTANCE
            if(temp != null){
                return temp
            }
            synchronized(this){
                val instance =  Room.databaseBuilder(context , PersonDatabase::class.java , "personDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
    }

    }
}