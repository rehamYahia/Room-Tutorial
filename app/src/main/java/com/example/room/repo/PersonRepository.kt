package com.example.room.repo

import androidx.lifecycle.LiveData
import com.example.room.dao.PersonDao
import com.example.room.entities.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class PersonRepository(private val personDao: PersonDao) {
   val getAllData: LiveData<List<Person>> = personDao.getAllData()

    suspend fun addPerson(person: Person){
        personDao.insertData(person)
    }

    suspend fun updateData(person: Person){
        personDao.updatePerson(person)
    }
}