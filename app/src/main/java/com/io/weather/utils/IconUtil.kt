package com.io.weather.utils

import android.content.Context
import com.io.weather.R

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-28
 */
fun getWeatherBack(context: Context?, weather: String?): Int {
    if (context == null || weather.isNullOrEmpty())
        return R.mipmap.back_100d
    return if (context.isDarkMode()) {
        getNightBack(weather)
    } else {
        getDayBack(weather)
    }
}

private fun getNightBack(weather: String?): Int {
    return when (weather) {
        "100" -> R.mipmap.back_100n
        "101" -> R.mipmap.back_101n
        "104" -> R.mipmap.back_104n
        "300" -> R.mipmap.back_300n
        "302" -> R.mipmap.back_302n
        "400" -> R.mipmap.back_400n
        "500" -> R.mipmap.back_500n
        "501" -> R.mipmap.back_501n
        "502" -> R.mipmap.back_502n
        "503" -> R.mipmap.back_503n
        "509" -> R.mipmap.back_509n
        "511" -> R.mipmap.back_511n
        "900" -> R.mipmap.back_900n
        else -> R.mipmap.back_100n
    }
}

private fun getDayBack(weather: String?): Int {
    return when (weather) {
        "100" -> R.mipmap.back_100d
        "101" -> R.mipmap.back_101d
        "104" -> R.mipmap.back_104d
        "300" -> R.mipmap.back_300d
        "302" -> R.mipmap.back_302d
        "400" -> R.mipmap.back_400d
        "500" -> R.mipmap.back_500d
        "501" -> R.mipmap.back_501d
        "502" -> R.mipmap.back_502d
        "503" -> R.mipmap.back_503d
        "509" -> R.mipmap.back_509d
        "511" -> R.mipmap.back_511d
        "900" -> R.mipmap.back_900d
        else -> R.mipmap.back_100d
    }
}