package com.example.room.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.entities.Person
import com.example.room.ui.MainActivity
import com.example.room.ui.UpdateActivity
import kotlin.properties.Delegates

class PersonAdapter(private val list : List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    lateinit var currentId:String
    lateinit var currentFirstName:String
    lateinit var currentLastName:String
    lateinit var currentAge:String
    lateinit var context:Context

    fun getCurrentObject():Person{
        return Person(currentId.toInt(),currentFirstName , currentLastName,currentAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item , parent , false))
    }

    override fun getItemCount(): Int {
       return list.size
    }



    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.firstName.text = list[position].firstName
        holder.lasttName.text = list[position].lastName
        holder.age.text = list[position].age

        holder.itemView.setOnClickListener{
            startActivity(context ,  Intent(context , UpdateActivity::class.java))
             currentId = list[position].id.toString()
            currentFirstName = list[position].firstName
            currentLastName = list[position].lastName
            currentAge  = list[position].age
        }
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var id = itemView.findViewById<TextView>(R.id.id)
         var firstName = itemView.findViewById<TextView>(R.id.first_name)
         var lasttName = itemView.findViewById<TextView>(R.id.last_name)
         var age = itemView.findViewById<TextView>(R.id.age)
    }
}