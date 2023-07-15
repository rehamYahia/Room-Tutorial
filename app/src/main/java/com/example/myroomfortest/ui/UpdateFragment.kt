package com.example.myroomfortest.ui

import android.location.Address
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.myroomfortest.R
import com.example.myroomfortest.database.entities.Adress
import com.example.myroomfortest.database.entities.PersonModel
import com.example.myroomfortest.databinding.FragmentUpdateBinding
import com.example.myroomfortest.view_model.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class UpdateFragment : Fragment() {

    private  var _binding: FragmentUpdateBinding?=null
    private val binding get() = _binding!!
    private val personViewModel:PersonViewModel by viewModels()
    private val args : UpdateFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.updateFirstName.editText?.setText(args.current.firstName)
        binding.updateLastName.editText?.setText(args.current.lastName)
        binding.updateAge.editText?.setText(args.current.age)
        binding.updateAddNum.editText?.setText(args.current.adress.adressName)
        binding.updateAddNum.editText?.setText(args.current.adress.adressNumber)

        binding.update.setOnClickListener {
            val person = PersonModel(args.current.id, binding.updateFirstName.editText?.text.toString() ,
                binding.updateLastName.editText?.text.toString() , binding.updateAge.editText?.text.toString(),
                Adress(binding.updateAddNam.editText?.text.toString() , binding.updateAddNum.editText?.text.toString())
            )
            personViewModel.updateData(person)
        }

        binding.deleteUser.setOnClickListener {
            personViewModel.deleteUser(args.current)
        }

        binding.deleteAllUser.setOnClickListener {
            personViewModel.deleteAllUsers()
        }
    }

}