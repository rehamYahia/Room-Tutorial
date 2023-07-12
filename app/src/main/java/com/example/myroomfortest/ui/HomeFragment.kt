package com.example.myroomfortest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomfortest.R
import com.example.myroomfortest.database.entities.PersonModel
import com.example.myroomfortest.view_model.PersonViewModel
import com.example.room.adapter.PersonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val personViewModel:PersonViewModel   by viewModels()
    private lateinit var insertToRoom:Button
    private lateinit var getFromRoom:Button
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var age:EditText
    private lateinit var recycler:RecyclerView
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initViews(view)
        insertToRoom.setOnClickListener {
            if (firstName.text.toString().trim().isNotEmpty() && lastName.text.toString().trim()
                    .isNotEmpty() && age.text.toString().trim().isNotEmpty()
            ) {
                lifecycleScope.launch {
                    personViewModel.insert(PersonModel(0 , firstName.text.toString() , lastName.text.toString() , age.text.toString()))
                }
            }
        }
        getFromRoom.setOnClickListener {
//        val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment()
//        navController.navigate(action)
            lifecycleScope.launch {
                personViewModel.getData()
            }
            personViewModel._personLiveData.observe(viewLifecycleOwner , Observer {
                recycler.adapter= PersonAdapter(it)
                recycler.layoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
            })
        }


    }

    private fun initViews(view: View){
        insertToRoom = view.findViewById(R.id.insert)
        getFromRoom = view.findViewById(R.id.get)
        firstName = view.findViewById(R.id.eFirstName)
        lastName = view.findViewById(R.id.eLastName)
        age = view.findViewById(R.id.eAge)
        recycler = view.findViewById(R.id.recycler)
    }
}