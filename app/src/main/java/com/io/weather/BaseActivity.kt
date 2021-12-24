package com.io.weather

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.io.weather.utils.setAndroidNativeLightStatusBar
import com.io.weather.utils.transparentStatusBar

/**
 * @desc base activity
 *
 * @author Vo7ice on 2021-12-21
 */
abstract class BaseActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initView()
    }

    private fun initView() {
        // 加载动画
        installSplashScreen()
        // 透明状态栏
        transparentStatusBar()
        // 状态栏反色
        setAndroidNativeLightStatusBar()
    }
}