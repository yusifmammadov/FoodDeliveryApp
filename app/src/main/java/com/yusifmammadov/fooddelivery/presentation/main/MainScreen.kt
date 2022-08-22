package com.yusifmammadov.fooddelivery.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yusifmammadov.fooddelivery.presentation.components.FoodyBottomNavBar
import com.yusifmammadov.fooddelivery.presentation.navigation.MainNavHost
import com.yusifmammadov.fooddelivery.presentation.navigation.Screen
import com.yusifmammadov.fooddelivery.presentation.navigation.foodyBottomNavBarScreens
import com.yusifmammadov.fooddelivery.presentation.navigation.navigateSingleTopTo

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = foodyBottomNavBarScreens.find {
        it.route == currentDestination?.route
    } ?: Screen.Home

    Scaffold(
        bottomBar = {
            FoodyBottomNavBar(
                screens = foodyBottomNavBarScreens,
                onSelected = { route ->
                    navController.navigateSingleTopTo(route)
                },
                currentScreen = currentScreen.route
            )
        }
    ) {
        MainNavHost(navController = navController)
    }
}