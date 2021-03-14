package com.allweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allweather.repository.AllWeatherRepository
import com.allweather.model.Place
import com.allweather.model.QueryPlaceResult
import com.allweather.network.Resource
import kotlinx.coroutines.launch

class PlaceViewModel : ViewModel() {

    private val repository = AllWeatherRepository
    // placeList may be used afterward to store the city displayed as cache.



    private val _searchPlace = MutableLiveData<Resource<QueryPlaceResult>>()
    val searchPlace: LiveData<Resource<QueryPlaceResult>> = _searchPlace

    fun searchPlaces(query: String) = viewModelScope.launch {
        _searchPlace.value = Resource.loading(null)
        _searchPlace.value = repository.searchPlaces(query)
    }

}