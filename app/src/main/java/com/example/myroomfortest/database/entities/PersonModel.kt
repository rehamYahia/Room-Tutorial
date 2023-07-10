package com.example.myroomfortest.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personTable")
data class PersonModel (@PrimaryKey(autoGenerate = true)val id:Int, val firstName:String, val lastName:String, val age:String)