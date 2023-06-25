package com.example.room.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room.database.PersonDatabase
import com.example.room.entities.Person
import com.example.room.repo.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) :AndroidViewModel(application) {
//   private var _readData:MutableStateFlow<ArrayList<Person>?>  = MutableStateFlow(null)
    var readData: LiveData<List<Person>>?=null
    val personRepository:PersonRepository

    init {
        val personDao = PersonDatabase.getInstance(application).getDao()
         personRepository = PersonRepository(personDao)
        readData =   personRepository.getAllData
    }

    fun addUser(person:Person)
    {
        viewModelScope.launch {
            personRepository.addPerson(person)
        }
    }

    fun update(person: Person){
        viewModelScope.launch {
            personRepository.updateData(person)
        }
    }
}