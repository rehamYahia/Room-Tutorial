package com.example.myroomfortest.database.room_builder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.entities.PersonModel

@Database(entities = [PersonModel::class] , exportSchema = false , version = 1)
abstract class PersonDatabase :RoomDatabase() {
   public abstract fun getDao():PersonDao
//companion object{
//
//   var INSTANCE:PersonDatabase ?=null
//   fun getRoomInstance(context: Context): PersonDatabase? {
//      if(INSTANCE != null){
//         return INSTANCE
//      }
//      synchronized(this)
//      {
//         INSTANCE = Room.databaseBuilder(context , PersonDatabase::class.java , "personDatabase")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//      }
//      return INSTANCE
//   }
//}

}