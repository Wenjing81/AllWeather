package com.allweather.app

import android.app.Application
import android.content.Context

class AllWeatherApplication : Application() {

    companion object {
        const val TOKEN = "9ff41582de514a658ac5f523363a6d08"
        lateinit var context: Context

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}