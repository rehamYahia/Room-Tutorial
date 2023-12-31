package com.example.myroomfortest.repo


import android.app.Person
import androidx.lifecycle.LiveData
import com.example.myroomfortest.database.dao.PersonDao
import com.example.myroomfortest.database.entities.PersonModel

class PersonRepoImp(val personDao: PersonDao):PersonRepo {
    override suspend fun insertPerson(person: PersonModel) {
        personDao.insertDataToLocal(person)
    }

    override  fun getAllPerson(): LiveData<List<PersonModel>> = personDao.getDataFromLocal()
    override suspend fun updateData(person: PersonModel) {
        personDao.updateData(person)
    }

    override suspend fun deleteUser(person: PersonModel) {
        personDao.deleteUser(person)
    }

    override suspend fun deleteAllUser() {
     personDao.deleteAllUsers()
    }

    override fun searchForRoom(search: String): LiveData<List<PersonModel>> =  personDao.searchForRoom(search)


}