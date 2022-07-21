package com.yusifmammadov.fooddelivery.presentation.navigation

sealed class Screen (val route: String) {

    object Splash: Screen("splash_screen")
    object Onboarding: Screen("onboarding_screen")
    object Registration: Screen("registration_screen")
    object Home: Screen("home_screen")
}