package com.yusifmammadov.fooddelivery.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.yusifmammadov.fooddelivery.R

sealed class OnBoardingPage (
    @StringRes val header: Int,
    @StringRes val body: Int,
    @DrawableRes val drawable: Int) {

    object First : OnBoardingPage(
        header = R.string.onboarding_header_first,
        body = R.string.onboarding_body_first,
        drawable = R.drawable.onboarding_first
    )
    object Second: OnBoardingPage(
        header = R.string.onboarding_header_second,
        body = R.string.onboarding_body_second,
        drawable = R.drawable.onboarding_second
    )
}