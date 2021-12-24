package com.io.weather.common

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
object Router {
    const val HOME_PAGE_ROUTE = "home_page_route"
    const val WEATHER_LIST_ROUTE = "weather_list_route"
    const val CITY_LIST_ROUTE = "city_list_route"
}

class NavActions(navController: NavHostController) {
    val toWeatherList: () -> Unit = {
        navController.navigate(Router.WEATHER_LIST_ROUTE)
    }

    val toCityList: () -> Unit = {
        navController.navigate(Router.CITY_LIST_ROUTE)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = {
            expandVertically(animationSpec = tween(300))
        },
        exitTransition = {
            shrinkOut(animationSpec = tween(300))
        },
        content = content
    )
}