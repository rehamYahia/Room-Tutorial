package com.example.myroomfortest.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
@Entity(tableName = "personTable")
data class PersonModel(@PrimaryKey(autoGenerate = true) val id:Int, val firstName: String?, val lastName:String?, val age:String?)
    : Parcelable


