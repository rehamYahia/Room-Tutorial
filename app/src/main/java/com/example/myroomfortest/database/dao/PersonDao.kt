package com.example.myroomfortest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myroomfortest.database.entities.PersonModel

@Dao
interface PersonDao {
    @Query("SELECT * FROM personTable")
     fun getDataFromLocal():LiveData<List<PersonModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDataToLocal(person:PersonModel)

    @Update
    suspend fun updateData(person: PersonModel)
}