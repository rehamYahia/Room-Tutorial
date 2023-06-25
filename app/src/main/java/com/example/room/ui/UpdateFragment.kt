package com.example.room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.room.adapter.PersonAdapter
import com.example.room.databinding.FragmentUpdateBinding
import com.example.room.entities.Person
import com.example.room.view_model.PersonViewModel

class UpdateFragment : Fragment() {

    private lateinit var personViewModel: PersonViewModel
    private lateinit var personAdapter: PersonAdapter

    private  var _binding: FragmentUpdateBinding?=null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var firstName:String
    private lateinit var lastName :String
    private lateinit var age:String
    private val args :UpdateFragmentArgs by navArgs()
     var data:Person?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUpdateBinding.inflate(inflater , container , false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personViewModel = activity?.let { ViewModelProvider(it).get(PersonViewModel::class.java) }!!
         firstName = binding.updateFirstName.toString()
         lastName = binding.updateLastName.toString()
         age = binding.updateEAge.toString()
         data = args.currentUser

        showCurrentData()
        binding.update.setOnClickListener {
            updateData()
        }
    }

    fun showCurrentData(){
        firstName = data!!.firstName.toString()
        lastName = data!!.lastName.toString()
        age = data!!.age.toString()
    }

    fun updateData(){
        if(firstName.trim().isNotEmpty() && lastName.trim().isNotEmpty() && age.trim().isNotEmpty()){
            personViewModel.update(Person(data!!.id ,firstName , lastName , age ))
        }

    }
}