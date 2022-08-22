package com.yusifmammadov.fooddelivery.presentation.model

import androidx.annotation.DrawableRes

data class DealItem(
    @DrawableRes val img: Int,
    val text: String,
    val cta: String
)
