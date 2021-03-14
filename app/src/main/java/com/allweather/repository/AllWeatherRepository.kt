package com.allweather.repository

import com.allweather.common.BaseRepository
import com.allweather.model.QueryPlaceResult
import com.allweather.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AllWeatherRepository : BaseRepository() {

    private val placeServiceApi = NetworkService.create(PlaceService::class.java)
    private var handler = ResponseHandler()//todo 修改为注入

    suspend fun searchPlaces(query: String): Resource<QueryPlaceResult> {
        return try {
            withContext(Dispatchers.IO) {
                val response = placeServiceApi.searchPlaces(query)
                handleResponseResult(response, handler, "searchPlaces")
            }
        } catch (e: Exception) {
            handler.handleException(e, "searchPlaces")
        }
    }


}
