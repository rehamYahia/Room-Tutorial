package com.example.myroomfortest.repo


import android.app.Person
import androidx.lifecycle.LiveData
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.entities.PersonModel

class PersonRepoImp(val personDao: PersonDao):PersonRepo {
    override suspend fun insertPerson(person: PersonModel) {
        personDao.insertDataToLocal(person)
    }

    override suspend fun getAllPerson(): LiveData<List<PersonModel>> = personDao.getDataFromLocal()


}