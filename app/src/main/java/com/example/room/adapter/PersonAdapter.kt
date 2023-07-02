package com.example.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.entities.Person
import com.example.room.ui.HomeFragmentDirections

class PersonAdapter(private val list : List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item , parent , false))
    }

    override fun getItemCount(): Int {
       return list.size
    }



    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.firstName.text = list[position].firstName
        holder.lastName.text = list[position].lastName
        holder.age.text = list[position].age

        holder.itemView.setOnClickListener{
            val data = list[position]
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(data)
            findNavController(it).navigate(action)
        }
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var id: TextView = itemView.findViewById(R.id.id)
         var firstName: TextView = itemView.findViewById(R.id.first_name)
         var lastName: TextView = itemView.findViewById(R.id.last_name)
         var age: TextView = itemView.findViewById(R.id.age)

    }
}