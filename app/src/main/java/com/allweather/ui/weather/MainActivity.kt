package com.allweather.ui.weather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.allweather.R
import com.allweather.viewmodel.PlaceViewModel

class MainActivity : AppCompatActivity() {

    val placeViewModel by lazy { ViewModelProvider(this).get(PlaceViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("First Activity onCreate",this.toString())
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("First Activity onStart",this.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.d("First Activity onResume",this.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d("First Activity onPause",this.toString())
    }
    override fun onStop() {
        super.onStop()
        Log.d("First Activity onStop",this.toString())
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("First Activity onDestroy",this.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("First Activity onRestart",this.toString())
    }
}