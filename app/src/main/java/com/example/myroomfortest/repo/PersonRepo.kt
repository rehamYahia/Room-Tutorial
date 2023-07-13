package com.example.myroomfortest.repo

import android.app.Person
import androidx.lifecycle.LiveData
import com.example.myroomfortest.database.entities.PersonModel

interface PersonRepo {
    suspend fun insertPerson(person: PersonModel)

    fun getAllPerson(): LiveData<List<PersonModel>>

    suspend fun updateData(person: PersonModel)
}