package com.example.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int ?= null,
    var firstName:String,
    var lastName:String,
    var age:String
)


