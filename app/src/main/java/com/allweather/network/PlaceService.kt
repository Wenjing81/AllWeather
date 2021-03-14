package com.allweather.network

import com.allweather.app.AllWeatherApplication
import com.allweather.model.QueryPlaceResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
//update the information in English.
    @GET("v2/place?token=${AllWeatherApplication.TOKEN}&lang=en_US")
    //zh_CN
    suspend fun searchPlaces(@Query("query") query: String): Response<QueryPlaceResult>
}