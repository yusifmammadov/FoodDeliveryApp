package com.yusifmammadov.fooddelivery.presentation.navigation


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yusifmammadov.fooddelivery.presentation.home.HomeScreen
import com.yusifmammadov.fooddelivery.presentation.main.MainScreen
import com.yusifmammadov.fooddelivery.presentation.onboarding.OnBoardingScreen
import com.yusifmammadov.fooddelivery.presentation.registration.RegistrationScreen
import com.yusifmammadov.fooddelivery.presentation.splash.SplashScreen

@ExperimentalPagerApi
@Composable
fun FoodyNavHost(
    navController: NavHostController,
    afterSplashRoute: String,
    modifier: Modifier = Modifier) {


    NavHost(navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier) {

        composable(Screen.Splash.route) {
            SplashScreen(onSplashFinished = {
                navController.popBackStack()
                navController.navigate(afterSplashRoute)
            })
        }

        composable(Screen.Onboarding.route) {
            OnBoardingScreen(
                navigateToRegistration = {
                    navController.popBackStack()
                    navController.navigate(Screen.Registration.route)
                })
        }

        composable(Screen.Registration.route) {
            RegistrationScreen(){
                navController.popBackStack()
                navController.navigate(Graph.MAIN)
            }
        }

        composable(Graph.MAIN) {
            MainScreen()
        }

    }
}


@Composable
fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = Graph.MAIN
    ) {

        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.Profile.route) {
            Text(text = "Profile Screen")
        }

        composable(Screen.Chats.route) {
            Text(text = "Message Screen")
        }

        composable(Screen.Cart.route) {
            Text(text = "Cart Screen")
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

object Graph {
    const val MAIN = "main_graph"
}

val foodyBottomNavBarScreens = listOf(Screen.Home, Screen.Profile, Screen.Cart, Screen.Chats)