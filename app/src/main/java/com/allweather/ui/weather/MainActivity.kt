package com.allweather.ui.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.allweather.R
import com.allweather.viewmodel.PlaceViewModel

class MainActivity : AppCompatActivity() {

    val placeViewModel by lazy { ViewModelProvider(this).get(PlaceViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}