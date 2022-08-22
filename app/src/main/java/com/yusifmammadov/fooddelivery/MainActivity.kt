package com.yusifmammadov.fooddelivery

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yusifmammadov.fooddelivery.presentation.navigation.FoodyNavHost
import com.yusifmammadov.fooddelivery.presentation.navigation.Screen
import com.yusifmammadov.fooddelivery.presentation.splash.SplashScreen
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.util.Constants
import com.yusifmammadov.fooddelivery.util.rememberScreenHeight

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE)
        val isOnboardingFinished = sharedPrefs.getBoolean(Constants.ONBOARDING_FINISHED, false)
        val afterSplashRoute = if (isOnboardingFinished) Screen.Home.route else Screen.Onboarding.route
        setContent {
            FoodDeliveryAppTheme {
                androidx.compose.material.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodyApp(afterSplashRoute)
                }

            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun FoodyApp(
    afterSplashRoute: String
) {
    val navController = rememberNavController()
    val screenHeight = rememberScreenHeight()
    FoodyNavHost(navController = navController, afterSplashRoute = afterSplashRoute)
}