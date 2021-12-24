package com.io.weather.common.lce

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.io.weather.R

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */
@Composable
fun ErrorContent(
    modifier: Modifier = Modifier,
    onErrorClick: () -> Unit
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.weather_error)
    )

    val process by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onSecondary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = process,
            modifier = Modifier.size(130.dp)
        )
        Button(onClick = onErrorClick) {
            Text(text = stringResource(id = R.string.bad_network_view_tip))
            
        }
    }
}