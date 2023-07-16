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
                        getImageAsBitmap()
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

    private suspend fun getImageAsBitmap(): Bitmap {
        val loading:ImageLoader = ImageLoader(requireActivity().applicationContext)
        val request: ImageRequest = ImageRequest.Builder(requireActivity().applicationContext)
            .data("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.freepnglogos.com%2Fuploads%2Fsamsung-logo-text-png-1.png&tbnid=RIJ2h-iy9VAu5M&vet=10CDEQMyjNAmoXChMI4L3YjuyTgAMVAAAAAB0AAAAAEAU..i&imgrefurl=https%3A%2F%2Fwww.freepnglogos.com%2Fpics%2Fsamsung-logo-png&docid=mkQyZhxU4xNWZM&w=2272&h=1704&q=any%20image%20with%20type%20png&ved=0CDEQMyjNAmoXChMI4L3YjuyTgAMVAAAAAB0AAAAAEAU")
            .build()
        val result = (loading.execute(request)as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }


}