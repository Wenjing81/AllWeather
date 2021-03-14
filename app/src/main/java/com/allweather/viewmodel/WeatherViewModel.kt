package com.allweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allweather.model.Place
import com.allweather.model.QueryPlaceResult
import com.allweather.network.Resource
import com.allweather.repository.AllWeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = AllWeatherRepository
    // placeList may be used afterward to store the city displayed as cache.


}