package com.allweather.network

import android.util.Log
import retrofit2.HttpException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleError(msg: String): Resource<T> {
        return Resource.error(msg, null)
    }

    fun <T : Any> handleException(e: Exception, debugInfo: String): Resource<T> {
        Log.d("AllWeather", debugInfo)
        return when (e) {
            is HttpException -> {
                val it = getErrorMessage(e.code())
                Resource.error(it, null)
            }
            is SocketTimeoutException -> {
                val it = getErrorMessage(ErrorCodes.SocketTimeOut.code)
                Resource.error(it, null)
            }
            else -> {
                Resource.error(e.message.orEmpty(), null)
            }
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            //400 -> "Unauthorised"
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "other wrong(HttpException)"
        }
        /******标准的协议******
        400 Bad Request
        401 Unauthorized（RFC 7235）
        402 Payment Required
        403 Forbidden
        404 Not Found
        405 Method Not Allowed
        406 Not Acceptable
        407 Proxy Authentication Required（RFC 2617）
        408 Request Timeout
        409 Conflict
        410 Gone
        411 Length Required
        412 Precondition Failed（RFC 7232）
        413 Request Entity Too Large（RFC 7231）
        414 Request-URI Too Long（RFC 7231）
        415 Unsupported Media Type
        416 Requested Range Not Satisfiable（RFC 7233）
        417 Expectation Failed
        418 I'm a teapot（RFC 2324）
        421 Misdirected Request （RFC 7540）
        422 Unprocessable Entity（WebDAV；RFC 4918 ）
        423 Locked（WebDAV；RFC 4918）
        424 Failed Dependency（WebDAV；RFC 4918）
        425 Too Early (RFC 8470)
        426 Upgrade Required（RFC 2817）
        428 Precondition Required (RFC 6585)
        429 Too Many Requests （RFC 6585）
        431 Request Header Fields Too Large （RFC 6585）
        451 Unavailable For Legal Reasons
         ******标准的协议******/
    }
}