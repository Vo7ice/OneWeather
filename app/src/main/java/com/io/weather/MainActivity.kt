package com.io.weather

import android.os.Bundle
import androidx.activity.compose.setContent
import com.google.gson.Gson
import com.io.weather.common.GrayAppAdapter
import com.io.weather.room.entity.CityInfo
import com.io.weather.ui.theme.OneWeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    companion object {
        private const val WIDGET_CITY_INFO = "widget_city_info"

        fun actionNewStart() {

        }
    }

    private var defaultCityInfo: CityInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val infoString = intent.getStringExtra(WIDGET_CITY_INFO) ?: ""
        if (infoString.isNotEmpty())
            defaultCityInfo = Gson().fromJson(infoString, CityInfo::class.java)

        setContent {
            OneWeatherTheme {
                GrayAppAdapter {
                    NavGraph(default = defaultCityInfo)
                }
            }
        }
    }
}