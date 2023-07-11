package com.example.myroomfortest.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize


//@Parcelize
@Entity(tableName = "personTable")
data class PersonModel (@PrimaryKey(autoGenerate = true)val id:Int, val firstName:String, val lastName:String, val age:String)
//    : Parcelable {


//    private companion object : Parceler<PersonModel> {
//        override fun PersonModel.write(parcel: Parcel, flags: Int) {
//            // Custom write implementation
//        }
//
//        override fun create(parcel: Parcel): PersonModel {
//            // Custom read implementation
//            return PersonModel()
//        }
//    }
//}