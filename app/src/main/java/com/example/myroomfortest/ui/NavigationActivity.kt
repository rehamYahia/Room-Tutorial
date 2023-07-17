package com.example.myroomfortest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.example.myroomfortest.R
import com.example.myroomfortest.view_model.PersonViewModel
import com.example.room.adapter.PersonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : AppCompatActivity() {
    val personViewModel:PersonViewModel by viewModels ()
    lateinit var personAdapter:PersonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//        val search = menu?.findItem(R.id.search)
//        val searchView = search?.actionView as SearchView
//        searchView.isSubmitButtonEnabled = true
//        searchView.setOnQueryTextListener(this)
//        return true
//    }
//
//    override fun onQueryTextSubmit(query: String?): Boolean {
//      if(query != null){
//          SearchForRoom(query)
//      }
//        return true
//    }
//
//    override fun onQueryTextChange(query: String?): Boolean {
//        if(query != null){
//            SearchForRoom(query)
//        }
//        return true
//    }
//
//    fun SearchForRoom(query:String){
//        val search = "%$query%"
//        personViewModel.searchForRoom(search)
//        personViewModel.searchData.observe(this , Observer {
//            personAdapter = PersonAdapter(it)
//        })
//
//    }
}