package com.example.myroomfortest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroomfortest.database.entities.PersonModel
import com.example.myroomfortest.repo.PersonRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(val repoImp:PersonRepo) :ViewModel() {
   lateinit var _personLiveData: LiveData<List<PersonModel>>

    fun insert(personModel: PersonModel){
        viewModelScope.launch {
            repoImp.insertPerson(personModel)
        }
    }

    fun getData(){
        viewModelScope.launch {
            _personLiveData = repoImp.getAllPerson()
        }
    }

    fun updateData(person:PersonModel){
        viewModelScope.launch {
            repoImp.updateData(person)
        }
    }


}