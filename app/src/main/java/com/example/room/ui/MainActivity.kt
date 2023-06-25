package com.example.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.room.R
import com.example.room.adapter.PersonAdapter
import com.example.room.entities.Person
import com.example.room.view_model.PersonViewModel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

   lateinit var personViewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initial
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val firstName = findViewById<EditText>(R.id.eFirstName)
        val lastName = findViewById<EditText>(R.id.eLastName)
        val age = findViewById<EditText>(R.id.eAge)
        val insert = findViewById<Button>(R.id.insert)
        val get = findViewById<Button>(R.id.get)

       personViewModel = ViewModelProvider(this@MainActivity).get(PersonViewModel::class.java)
        insert.setOnClickListener {
            if(firstName.text.trim().toString().isNotEmpty() && lastName.text.trim().toString().isNotEmpty() && age.text.trim().toString().isNotEmpty()){
                personViewModel.addUser(Person(null, firstName.text.toString() , lastName.text.toString() , age.text.toString()))
                Toast.makeText(this@MainActivity , "inserted ",Toast.LENGTH_LONG).show()
            }
        }
        get.setOnClickListener {
            lifecycleScope.launch{
                personViewModel.readData?.observe(this@MainActivity  , Observer {
                    recycler.adapter = PersonAdapter(it)
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
                })
            }

        }


//        get.setOnClickListener {
//            lifecycleScope.launch{
//                flow<ArrayList<Person>> {
//                    personViewModel.readData?.collect {
//                        for(data in it) {
//                            emit(it)
//                        }
//                    }
//                }.buffer().collect{
//                    recycler.adapter = PersonAdapter(it)
//                    recycler.layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
//                }
//            }
//
//        }

        }
    }

