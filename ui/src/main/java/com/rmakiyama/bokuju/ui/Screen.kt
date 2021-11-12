package com.rmakiyama.bokuju.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Discover : Screen("discover")
    object MyPage : Screen("mypage")
}
