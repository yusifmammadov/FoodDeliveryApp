package com.yusifmammadov.fooddelivery.presentation.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.components.GradientButton
import com.yusifmammadov.fooddelivery.presentation.navigation.Screen
import com.yusifmammadov.fooddelivery.ui.theme.ButtonRoundedCornerShape
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.GreenA
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    screenHeight: Int,
    modifier: Modifier = Modifier,
    onOnboardingFinished: () -> Unit,
    viewModel: OnboardingViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier
            .fillMaxSize()) {

        HorizontalPager(count = 2,
            state = pagerState,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 32.dp)
                ) { position ->
            if (screenHeight < 480) {
                OnboardingPagerScreen2(onBoardingPage = pages[position])
            } else {
                OnboardingPagerScreen(onBoardingPage = pages[position])
            }
        }

        GradientButton(
            text = R.string.next,
            onClick = {
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    viewModel.onOnboardingFinished()
                    onOnboardingFinished()
                }
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally))

        Spacer(modifier = modifier
            .height(24.dp))

//        Button(onClick = { if (pagerState.currentPage < pagerState.pageCount - 1) {
//            coroutineScope.launch {
//                pagerState.animateScrollToPage(pagerState.currentPage + 1)
//            }
//
//        } },
//            shape = RoundedCornerShape(35),
//            modifier = modifier
//                .padding(
//                    top = 20.dp,
//                    bottom = 24.dp
//                )
//                .align(Alignment.CenterHorizontally)) {
//            Text(text = stringResource(id = R.string.next),
//                fontFamily = bentonSans,
//                fontWeight = FontWeight.Bold,
//                fontSize = 16.sp,
//                modifier = modifier
//                    .padding(
//                        start = 22.dp,
//                        end = 22.dp,
//                        top = 8.dp,
//                        bottom = 8.dp
//                    ))
//        }


    }
}


@ExperimentalPagerApi
@Composable
@Preview(showSystemUi = true)
fun OnBoardingScreenPreview() {
    FoodDeliveryAppTheme() {
        OnBoardingScreen(LocalConfiguration.current.screenHeightDp, onOnboardingFinished = {})
    }
}

@ExperimentalPagerApi
@Composable
@Preview(widthDp = 240, heightDp = 320, showBackground = true)
fun OnBoardingScreenPreview2() {
    FoodDeliveryAppTheme() {
        OnBoardingScreen(320, onOnboardingFinished = {})
    }
}

@ExperimentalPagerApi
@Composable
@Preview(widthDp = 620, heightDp = 980, showBackground = true)
fun OnBoardingScreenPreview3() {
    FoodDeliveryAppTheme() {
        OnBoardingScreen(screenHeight = 980, onOnboardingFinished = {})
    }
}


