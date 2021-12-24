package com.io.weather.common.lce

import androidx.compose.runtime.Composable
import com.io.weather.common.*

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-24
 */
@Composable
fun <T> LcePage(
    loadingState: LoadingState<T>,
    onErrorClick: () -> Unit,
    content: @Composable (T)-> Unit
) = when (loadingState) {
    Loading -> LoadingContent()
    is LoadingError -> TODO()
    is LoadingNoContent -> TODO()
    is LoadingSuccess -> TODO()
}