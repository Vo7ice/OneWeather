package com.io.weather

import android.app.Application
import com.qweather.sdk.view.HeConfig

/**
 * @desc Application
 *
 * @author Vo7ice on 2021-12-20
 */
class WeatherApp : Application() {

    companion object {
        private const val PUBLIC_ID = "HE2112101449391854"
        private const val PUBLIC_KEY = "6ea4d706da864a859bf158510dedf203"
    }

    override fun onCreate() {
        super.onCreate()
        HeConfig.init(PUBLIC_ID, PUBLIC_KEY)
        if (BuildConfig.DEBUG)
            HeConfig.switchToDevService()
        else
            HeConfig.switchToBizService()
    }
}