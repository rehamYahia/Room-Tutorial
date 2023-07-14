package com.example.myroomfortest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomfortest.database.entities.PersonModel
import com.example.myroomfortest.databinding.FragmentHomeBinding
import com.example.myroomfortest.view_model.PersonViewModel
import com.example.room.adapter.PersonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private val personViewModel:PersonViewModel   by viewModels()

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.insert.setOnClickListener {
            if (binding.eFirstName.text.toString().trim().isNotEmpty() && binding.eLastName.text.toString().trim()
                    .isNotEmpty() && binding.eAge.text.toString().trim().isNotEmpty()&&
                binding.addName.text.toString().trim().isNotEmpty() &&
                binding.addNumber.text.toString().trim().isNotEmpty()
            ) {
                lifecycleScope.launch {
                    personViewModel.insert(PersonModel(0 , binding.eFirstName.text.toString() ,
                        binding.eLastName.text.toString() , binding.eAge.text.toString() , Address(binding.addName.text.toString() , binding.addNumber.text.toString())))
                }
            }
        }
        binding.get.setOnClickListener {
            personViewModel.getData()
            personViewModel._personLiveData.observe(viewLifecycleOwner , Observer {
                binding.recycler.adapter= PersonAdapter(it)
                binding.recycler.layoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
            })
        }


    }


}