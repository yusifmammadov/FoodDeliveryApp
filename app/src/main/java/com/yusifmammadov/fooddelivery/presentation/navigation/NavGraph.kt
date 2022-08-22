package com.yusifmammadov.fooddelivery.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yusifmammadov.fooddelivery.presentation.home.HomeScreen
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
                navController.navigate(Screen.Home.route)
            }
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}