package com.io.weather.common.lce

import androidx.compose.runtime.Composable
import com.io.weather.common.*

/**
 * @desc 通过State进行控制的Loading、Content、Error页面
 *
 * @param loadingState 数据State
 * @param onErrorClick 错误时的点击事件
 * @param content 数据加载成功时应显示的可组合项
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
    is LoadingError -> ErrorContent(onErrorClick = onErrorClick)
    is LoadingNoContent -> NoContent(tip = loadingState.reason)
    is LoadingSuccess<T> -> content(loadingState.data)
}