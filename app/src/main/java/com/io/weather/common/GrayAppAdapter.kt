package com.io.weather.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@Composable
fun GrayAppAdapter(isNeedGray: Boolean = isNeedGray(), content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        content()
        if (isNeedGray) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = Color.White,
                    blendMode = BlendMode.Saturation
                )
            }
        }
    }
}

fun isNeedGray(): Boolean {
    return false
}