package com.rmakiyama.bokuju.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.rmakiyama.bokuju.ui.Screen
import com.rmakiyama.bokuju.ui.discover.DiscoverScreen
import com.rmakiyama.bokuju.ui.home.HomeScreen
import com.rmakiyama.bokuju.ui.mypage.MyPageScreen

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Discover.route) { DiscoverScreen() }
        composable(Screen.MyPage.route) { MyPageScreen() }
    }
}
