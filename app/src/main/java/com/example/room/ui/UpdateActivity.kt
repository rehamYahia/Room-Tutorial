package com.example.room.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.room.R
import com.example.room.adapter.PersonAdapter
import com.example.room.view_model.PersonViewModel

class UpdateActivity : AppCompatActivity() {
    lateinit var personViewModel: PersonViewModel
    lateinit var personAdapter: PersonAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val firstName = findViewById<EditText>(R.id.update_FirstName)
        val lastName = findViewById<EditText>(R.id.update_LastName)
        val age = findViewById<EditText>(R.id.update_eAge)
        val update = findViewById<Button>(R.id.update)
        val person =personAdapter.getCurrentObject()



        personViewModel = ViewModelProvider(this@UpdateActivity).get(PersonViewModel::class.java)
        update.setOnClickListener {
            if(firstName.text.trim().toString().isNotEmpty() && lastName.text.trim().toString().isNotEmpty() && age.text.trim().toString().isNotEmpty()){
                person.firstName = firstName.text.toString()
                person.lastName = lastName.text.toString()
                person.age = age.text.toString()
                personViewModel.update(person)


            }
        }
    }
}