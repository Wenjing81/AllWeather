package com.allweather.app

import android.app.Application
import android.content.Context

class AllWeatherApplication : Application() {

    lateinit var context: Context

    companion object {
        //访问彩云天气API的Token, 定义成常数。
        const val TOKEN = "9ff41582de514a658ac5f523363a6d08"
    }
//初始化App里都会用到的东西，比如数据库，总会用到的变量，等等。
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}