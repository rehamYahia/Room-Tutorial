package com.example.myroomfortest.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import com.example.myroomfortest.R
import com.example.myroomfortest.database.entities.PersonModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    private lateinit var up_firstName: EditText
    private lateinit var up_lastName: EditText
    private lateinit var up_age: EditText
    private lateinit var update: Button
//    private val args : UpdateFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

//       up_firstName.text  = args.user.firstName.toString()  as Editable
//        up_lastName.text = args.user.lastName.toString() as Editable
//        up_age.text = args.user.age.toString() as Editable
        update.setOnClickListener {

        }
    }

    private fun initViews(view: View){
        update = view.findViewById(R.id.update)
        up_firstName = view.findViewById(R.id.update_FirstName)
        up_lastName = view.findViewById(R.id.update_LastName)
        up_age = view.findViewById(R.id.update_Age)

    }
}