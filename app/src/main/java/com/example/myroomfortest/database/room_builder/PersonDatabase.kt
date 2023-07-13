package com.example.myroomfortest.database.room_builder


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.entities.PersonModel

@Database(entities = [PersonModel::class] , exportSchema = false , version = 1)
abstract class PersonDatabase :RoomDatabase() {
   public abstract fun getDao():PersonDao

}