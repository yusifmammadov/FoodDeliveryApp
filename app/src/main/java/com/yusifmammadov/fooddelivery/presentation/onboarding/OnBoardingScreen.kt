package com.yusifmammadov.fooddelivery.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.components.GradientButton
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalLifecycleComposeApi::class)
@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navigateToRegistration: () -> Unit,
    viewModel: OnboardingViewModel = viewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isOnboardingFinished) {

        val currNavigateToRegistration by rememberUpdatedState(navigateToRegistration)

        LaunchedEffect(Unit) {
            viewModel.navigatedTo()
            currNavigateToRegistration()
        }
    }
    OnboardingContent(
        modifier = modifier,
        onOnboardingFinished = {
            viewModel.onOnboardingFinished()
        }
    )
    
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingContent(
    modifier: Modifier = Modifier,
    onOnboardingFinished: () -> Unit,
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        HorizontalPager(count = 2,
            state = pagerState,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) { position ->

            OnboardingPagerContent(onBoardingPage = pages[position])
        }

        Spacer(modifier = Modifier
            .heightIn(8.dp, 32.dp))

        GradientButton(
            text = R.string.next,
            onClick = {
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    onOnboardingFinished()
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally))

        Spacer(modifier = modifier
            .heightIn(16.dp, 24.dp))
    }
}


@ExperimentalPagerApi
@Composable
@Preview(showSystemUi = true)
fun OnBoardingScreenPreview() {
    FoodDeliveryAppTheme() {
        OnboardingContent() {

        }
    }
}

//@ExperimentalPagerApi
//@Composable
//@Preview(widthDp = 240, heightDp = 320, showBackground = true)
//fun OnBoardingScreenPreview2() {
//    FoodDeliveryAppTheme {
//        OnboardingContent {
//
//        }
//    }
//}
//
//@ExperimentalPagerApi
//@Composable
//@Preview(widthDp = 620, heightDp = 980, showBackground = true)
//fun OnBoardingScreenPreview3() {
//    FoodDeliveryAppTheme {
//        OnboardingContent {
//
//        }
//    }
//}
//

