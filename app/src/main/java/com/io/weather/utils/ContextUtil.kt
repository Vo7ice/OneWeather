package com.io.weather.utils

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.qweather.sdk.bean.base.Lang

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
fun Context.getDefaultLocale(): Lang {
    return when (resources.configuration.locales[0].toLanguageTag()) {
        "zh", "zh-CN" -> Lang.ZH_HANS
        "zh_rHK", "zh_rTW", "zh_HK", "zh_TW", "HK", "TW", "zh-TW", "zh-HK" -> Lang.ZH_HANT
        else -> Lang.EN
    }
}

fun Context.isDarkMode(): Boolean {
    val uiMode = (resources.configuration.uiMode) and (Configuration.UI_MODE_NIGHT_MASK)
    return uiMode == UiModeManager.MODE_NIGHT_YES
}

fun Context.checkNetState(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val networkCapabilities = connectivityManager?.getNetworkCapabilities(
        connectivityManager.activeNetwork
    )
    return when {
        networkCapabilities == null -> {
            false
        }
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
            XLog.d("current use cellular data.")
            true
        }
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
            XLog.d("current use wifi.")
            true
        }
        else -> {
            false
        }
    }
}