package com.io.weather.utils

import kotlinx.coroutines.Job

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */
fun Job?.checkCoroutines() {
    if (this?.isActive == true) return
    this?.cancel()
    XLog.d("already run, cancel the coroutines before.")
}