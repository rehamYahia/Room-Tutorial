package com.example.room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.adapter.PersonAdapter
import com.example.room.databinding.FragmentHomeBinding
import com.example.room.entities.Person
import com.example.room.view_model.PersonViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {


    private  var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    lateinit var personViewModel: PersonViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater , container , false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = binding.recycler
        val firstName = binding.eFirstName
        val lastName = binding.eLastName
        val age = binding.eAge
        personViewModel = ViewModelProvider(this@HomeFragment).get(PersonViewModel::class.java)
        binding.insert.setOnClickListener {
            if(firstName.text.trim().toString().isNotEmpty() && lastName.text.trim().toString().isNotEmpty() && age.text.trim().toString().isNotEmpty()){
                personViewModel.addUser(Person(null, firstName.text.toString() , lastName.text.toString() , age.text.toString()))
                Toast.makeText(activity , "inserted ", Toast.LENGTH_LONG).show()
            }
        }

        binding.get.setOnClickListener {
            lifecycleScope.launch{
                personViewModel.readData?.observe(viewLifecycleOwner  , Observer {
                    recycler.adapter = PersonAdapter(it)
                    recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                })
            }

        }
    }


}