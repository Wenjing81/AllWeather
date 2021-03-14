package com.allweather.common

import android.util.Log
import com.allweather.network.Resource
import com.allweather.network.ResponseHandler
import retrofit2.Response

open class BaseRepository {

    fun <T : Any> handleResponseResult(
        response: Response<T>,
        responseHandler: ResponseHandler,
        debugInfo: String
    ): Resource<T> {
        Log.d("AllWeather", debugInfo)
        return if (response.isSuccessful) {
            responseHandler.handleSuccess(response.body()!!)
        } else {
            responseHandler.handleError(response.errorBody()!!.string())
        }
    }
}