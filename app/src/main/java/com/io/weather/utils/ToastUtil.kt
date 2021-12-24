package com.io.weather.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */

private var mToast: Toast? = null

fun showToast(context: Context?, text: String?) {
    if (context == null || TextUtils.isEmpty(text)) return
    if (Thread.currentThread() === Looper.getMainLooper().thread) {
        showToast(context, text, Toast.LENGTH_SHORT)
    } else {
        Handler(context.mainLooper).post { showToast(context, text, Toast.LENGTH_SHORT) }
    }
}

fun showToast(context: Context?, resId: Int) {
    if (context == null) return
    if (Thread.currentThread() === Looper.getMainLooper().thread) {
        showToast(context, resId, Toast.LENGTH_SHORT)
    } else {
        Handler(context.mainLooper).post { showToast(context, resId, Toast.LENGTH_SHORT) }
    }
}

fun showLongToast(context:Context?, text:String?) {
    if (context == null || TextUtils.isEmpty(text)) return
    if (Thread.currentThread() === Looper.getMainLooper().thread) {
        showToast(context, text, Toast.LENGTH_LONG)
    } else {
        Handler(context.mainLooper).post { showToast(context, text, Toast.LENGTH_LONG) }
    }
}

fun showLongToast(context:Context?, resId:Int) {
    if (context == null) return
    if (Thread.currentThread() === Looper.getMainLooper().thread) {
        showToast(context, resId, Toast.LENGTH_LONG)
    } else {
        Handler(context.mainLooper).post { showToast(context, resId, Toast.LENGTH_LONG) }
    }
}


private fun showToast(context: Context?, text: String?, duration: Int) {
    if (TextUtils.isEmpty(text)) return
    cancelToast()
    if (mToast == null) {
        mToast = Toast.makeText(context, null as CharSequence?, duration)
    }
    mToast?.apply {
        setText(text)
        this.duration = duration
        show()
    }
}

fun showToast(context: Context?, resId: Int, duration: Int) {
    cancelToast()
    if (mToast == null) {
        mToast = Toast.makeText(context, resId, duration)
    } else {
        mToast?.setText(resId)
        mToast?.duration = duration
    }
    mToast?.show()
}

/**
 * cancel toast
 */
fun cancelToast() {
    mToast?.cancel()
}