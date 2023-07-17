package com.example.myroomfortest.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
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
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.myroomfortest.database.entities.PersonModel
import com.example.myroomfortest.databinding.FragmentHomeBinding
import com.example.myroomfortest.view_model.PersonViewModel
import com.example.room.adapter.PersonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
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
                    .isNotEmpty() && binding.eAge.text.toString().trim().isNotEmpty()
//                binding.addName.text.toString().trim().isNotEmpty() &&
//                binding.addNumber.text.toString().trim().isNotEmpty()
            ) {
                lifecycleScope.launch {
                    personViewModel.insert(PersonModel(0 , binding.eFirstName.text.toString() ,
                        binding.eLastName.text.toString() , binding.eAge.text.toString() ,
//                        Adress(binding.addName.text.toString() , binding.addNumber.text.toString()),
                        getBitmap()
                    ))
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

    private suspend fun getBitmap(): Bitmap {
        val loading = activity?.let { ImageLoader(it) }
        val request = activity?.let {
            ImageRequest.Builder(it)
                .data("https://avatars3.githubusercontent.com/u/14994036?s=400&u=2832879700f03d4b37ae1c09645352a352b9d2d0&v=4")
                .build()
        }

        val result = (request?.let { loading?.execute(it) } as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }


}