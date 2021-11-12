package com.rmakiyama.bokuju.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rmakiyama.bokuju.ui.R
import com.rmakiyama.bokuju.ui.Screen

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
internal fun MainScreen() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { paddingValues ->
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
private fun BottomNavigation(
    navController: NavHostController,
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        navigationItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.iconRes),
                        contentDescription = item.screen.route,
                    )
                },
                label = { Text(text = stringResource(item.labelRes)) },
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any {
                    it.route?.startsWith(item.screen.route) ?: false
                } ?: false,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

private sealed class NavigationItem(
    val screen: Screen,
    @DrawableRes val iconRes: Int,
    @StringRes val labelRes: Int,
) {
    object Home : NavigationItem(
        screen = Screen.Home,
        iconRes = R.drawable.ic_home,
        labelRes = R.string.navigation_label_home,
    )

    object Discover : NavigationItem(
        screen = Screen.Discover,
        iconRes = R.drawable.ic_discover,
        labelRes = R.string.navigation_label_discover,
    )

    object MyPage : NavigationItem(
        screen = Screen.MyPage,
        iconRes = R.drawable.ic_mypage,
        labelRes = R.string.navigation_label_mypage,
    )
}

private val navigationItems = listOf(
    NavigationItem.Home,
    NavigationItem.Discover,
    NavigationItem.MyPage,
)
