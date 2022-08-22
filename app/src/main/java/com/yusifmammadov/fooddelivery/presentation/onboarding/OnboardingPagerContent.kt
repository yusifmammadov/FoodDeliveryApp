package com.yusifmammadov.fooddelivery.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans

@Composable
fun OnboardingPagerContent(
    onBoardingPage: OnBoardingPage,
    modifier: Modifier = Modifier
) {
    
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.drawable),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        )

        Spacer(modifier = Modifier
            .weight(1f, false)
            .heightIn(8.dp, 32.dp)
        )
        
        Text(
            text = stringResource(id = onBoardingPage.header),
            fontFamily = bentonSans,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            lineHeight = 24.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
            )

        Spacer(modifier = Modifier
            .weight(1f, false)
            .heightIn(8.dp, 32.dp)
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
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun OnboardingPagerContentPreview() {
    OnboardingPagerContent(onBoardingPage = OnBoardingPage.First)
}