package com.example.myroomfortest.database.room_builder


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myroomfortest.database.converters.Converter
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.entities.PersonModel

@Database(entities = [PersonModel::class] , exportSchema = false , version = 1)
@TypeConverters(Converter::class)
abstract class PersonDatabase :RoomDatabase() {
   public abstract fun getDao():PersonDao

}