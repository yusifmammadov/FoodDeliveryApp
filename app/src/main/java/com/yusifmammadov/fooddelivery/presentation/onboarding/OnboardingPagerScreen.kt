package com.yusifmammadov.fooddelivery.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans

@Composable
fun OnboardingPagerScreen(onBoardingPage: OnBoardingPage,
    modifier: Modifier = Modifier) {
    
    Column() {
        Image(painter = painterResource(id = onBoardingPage.drawable), 
            contentDescription = null)
        
        Text(
            text = stringResource(id = onBoardingPage.header),
            fontFamily = bentonSans,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            lineHeight = 24.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
            )
        
        Text(
            text = stringResource(id = onBoardingPage.body),
            fontFamily = bentonSans,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
        )
    }
}

@Composable
fun OnboardingPagerScreen2(
    onBoardingPage: OnBoardingPage,
    modifier: Modifier = Modifier) {
    Column() {

        Text(
            text = stringResource(id = onBoardingPage.header),
            fontFamily = bentonSans,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            lineHeight = 24.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
        )

        Text(
            text = stringResource(id = onBoardingPage.body),
            fontFamily = bentonSans,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
        )
    }

}

@Composable
@Preview(showSystemUi = true)
fun OnboardingPagerScreenPreview() {
    OnboardingPagerScreen(onBoardingPage = OnBoardingPage.First)
}