package com.io.weather.model

import com.qweather.sdk.bean.air.AirNowBean
import com.qweather.sdk.bean.weather.WeatherDailyBean
import com.qweather.sdk.bean.weather.WeatherHourlyBean
import com.qweather.sdk.bean.weather.WeatherNowBean

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */
data class WeatherModel(
    val nowBaseBean: WeatherNowBean.NowBaseBean,
    val hourlyBeanList: List<WeatherHourlyBean.HourlyBean>,
    val dailyBean: WeatherDailyBean.DailyBean?,
    val dailyBeanList: List<WeatherDailyBean.DailyBean>,
    val airNowBean: AirNowBean.NowBean
)
