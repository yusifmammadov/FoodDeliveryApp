package com.yusifmammadov.fooddelivery.presentation.navigation

import androidx.annotation.DrawableRes
import com.yusifmammadov.fooddelivery.R

sealed class Screen (
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {

    object Splash: Screen("splash_screen", "Splash", 0)
    object Onboarding: Screen("onboarding_screen", "Onboarding", 0)
    object Registration: Screen("registration_screen", "Registration",0)
    object Home: Screen("home_screen", "Home", R.drawable.ic_home)
    object Profile: Screen("profile_screen", "Profile", R.drawable.ic_profile_nav)
    object Chats: Screen("message_screen", "Chats", R.drawable.ic_chat)
    object Cart: Screen ("cart_screen", "Cart", R.drawable.ic_cart)
}