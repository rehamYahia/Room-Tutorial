package com.example.myroomfortest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myroomfortest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }
}