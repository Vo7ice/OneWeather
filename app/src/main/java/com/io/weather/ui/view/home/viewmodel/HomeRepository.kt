package com.io.weather.ui.view.home.viewmodel

import android.app.Application
import com.google.gson.Gson
import com.io.weather.utils.XLog
import com.io.weather.utils.showToast
import com.qweather.sdk.bean.base.Code
import com.qweather.sdk.bean.base.Lang
import com.qweather.sdk.bean.base.Unit
import com.qweather.sdk.bean.weather.WeatherDailyBean
import com.qweather.sdk.bean.weather.WeatherHourlyBean
import com.qweather.sdk.bean.weather.WeatherNowBean
import com.qweather.sdk.view.HeContext.context
import com.qweather.sdk.view.QWeather
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@ViewModelScoped
class HomeRepository @Inject constructor(private val application: Application) {


    suspend fun getWeatherNow(location: String, lang: Lang) =
        suspendCancellableCoroutine<WeatherNowBean.NowBaseBean> { continuation ->
            QWeather.getWeatherNow(
                context,
                location,
                lang,
                Unit.METRIC,
                object : QWeather.OnResultWeatherNowListener {
                    override fun onError(e: Throwable?) {
                        XLog.d("getWeatherNow onError: $e")
                        showToast(context, e?.message)
                    }

                    override fun onSuccess(now: WeatherNowBean?) {
                        if (now != null) {
                            XLog.d("getWeather onSuccess: ${Gson().toJson(now)}")
                            if (Code.OK == now.code) {
                                continuation.resume(now.now)
                            } else {
                                val code: Code = now.code
                                XLog.w("failed code: $code")
                                showToast(context, code.txt)
                            }
                        }
                    }
                })
        }
    suspend fun getWeatherOneDay(location: String, lang: Lang) =
        suspendCancellableCoroutine<Pair<WeatherDailyBean?, List<WeatherDailyBean.DailyBean>>> { continuation ->
            QWeather.getWeather24Hourly(
                context,
                location,
                lang,
                Unit.METRIC,
                object : QWeather.OnResultWeatherHourlyListener {
                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onSuccess(hourly: WeatherHourlyBean?) {
                        TODO("Not yet implemented")
                    }

                })
        }

    suspend fun getWeatherOneWeek(location: String, lang: Lang) =
        suspendCancellableCoroutine<Pair<WeatherDailyBean.DailyBean?, List<WeatherDailyBean.DailyBean>>> { continuation ->
            QWeather.getWeather7D(
                context,
                location,
                lang,
                Unit.METRIC,
                object : QWeather.OnResultWeatherDailyListener {
                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onSuccess(daily: WeatherDailyBean?) {
                        TODO("Not yet implemented")
                    }

                })
        }
}

