package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.room.entities.Person



@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(person: Person)

    @Query("SELECT * FROM person")
    fun getAllData(): LiveData<List<Person>>

//    @Update
//    suspend fun updatePerson(person: Person)

}