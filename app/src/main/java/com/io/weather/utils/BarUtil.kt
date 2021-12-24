package com.io.weather.utils

import android.app.Activity
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat.Type.statusBars

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
fun Activity.transparentStatusBar() {
    val controller = ViewCompat.getWindowInsetsController(window.decorView)
    controller?.hide(statusBars())
    window.statusBarColor = Color.TRANSPARENT
}

fun Activity.setAndroidNativeLightStatusBar() {
    val controller = ViewCompat.getWindowInsetsController(window.decorView)
    controller?.isAppearanceLightNavigationBars = !isDarkMode()
}