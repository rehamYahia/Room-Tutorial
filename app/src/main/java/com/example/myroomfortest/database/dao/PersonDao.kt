package com.example.myroomfortest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myroomfortest.database.entities.PersonModel

@Dao
interface PersonDao {
    @Query("SELECT * FROM personTable")
     fun getDataFromLocal():LiveData<List<PersonModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDataToLocal(person:PersonModel)
}