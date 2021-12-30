package com.io.weather.utils

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-28
 */
@Composable
fun ImageLoader(
    data: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    when (data) {
        is String -> {
            val bitmap = BitmapFactory.decodeFile(data)
            Image(
                modifier = modifier,
                painter = BitmapPainter(bitmap.asImageBitmap()),
                contentDescription = "",
                contentScale = contentScale
            )
        }
        is Int -> {
            Image(
                painter = painterResource(data),
                contentDescription = "",
                modifier = modifier,
                contentScale = contentScale
            )
        }
        else -> {
            throw IllegalArgumentException("params do not meet the demand, data = $data, please check again!")
        }
    }
}