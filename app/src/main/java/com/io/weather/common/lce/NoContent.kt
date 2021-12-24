package com.io.weather.common.lce

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.io.weather.R

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */
@Composable
fun NoContent(tip: String = "current no content!") {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.weather_no_data)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(130.dp)
        )
        Text(text = tip, modifier = Modifier.padding(10.dp))
    }
}