package com.io.weather

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.io.weather.common.NavActions
import com.io.weather.room.entity.CityInfo
import com.io.weather.common.Router
import com.io.weather.common.composable
import com.io.weather.ui.view.home.viewmodel.HomeViewModel


/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@OptIn(
    ExperimentalAnimationApi::class, ExperimentalPagerApi::class, ExperimentalPermissionsApi::class
)
@Composable
fun NavGraph(default: CityInfo?, router: String = Router.HOME_PAGE_ROUTE) {
    val navController = rememberAnimatedNavController()
    val actions = remember(navController) { NavActions(navController) }
    AnimatedNavHost(navController = navController, startDestination = router) {
        composable(Router.HOME_PAGE_ROUTE) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            LaunchedEffect(Unit) {
                if (default != null) {

                }
            }
        }
    }
}