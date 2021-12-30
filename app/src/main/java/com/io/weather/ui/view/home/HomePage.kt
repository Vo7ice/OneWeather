package com.io.weather.ui.view.home

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.io.weather.common.Loading
import com.io.weather.common.lce.LcePage
import com.io.weather.model.WeatherModel
import com.io.weather.room.entity.CityInfo
import com.io.weather.ui.view.home.viewmodel.HomeViewModel
import com.io.weather.utils.ImageLoader
import com.io.weather.utils.getWeatherBack

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@Composable
fun HomePage(
    homeViewModel: HomeViewModel,
    cityInfo: CityInfo,
    onErrorClick: () -> Unit,
    cityList: () -> Unit,
    cityListClick: () -> Unit
) {
    val context = LocalContext.current
    val homeModel by homeViewModel.weatherModel.observeAsState(Loading)
    val scrollState = rememberScrollState()
    val fontSize = (50f / (scrollState.value / 2) * 70).coerceAtLeast(20f).coerceAtMost(45f).sp
    val config = LocalConfiguration.current
    LcePage(loadingState = homeModel, onErrorClick = onErrorClick) { weather ->
        Box(modifier = Modifier.fillMaxSize()) {
            ImageLoader(
                data = getWeatherBack(context, weather.nowBaseBean.icon),
                modifier = Modifier.fillMaxSize()
            )
            val isLand = config.orientation == Configuration.ORIENTATION_LANDSCAPE
            if (isLand) {

            } else {

            }
        }
    }
}

@Composable
private fun VerticalWeather(
    fontSize: TextUnit,
    cityInfo:CityInfo,
    cityList:()->Unit,
    cityListClick: () -> Unit,
    weather:WeatherModel,
    scrollState: ScrollState
) {
    // 正常状态下是隐藏状态，向上滑动时展示
}
