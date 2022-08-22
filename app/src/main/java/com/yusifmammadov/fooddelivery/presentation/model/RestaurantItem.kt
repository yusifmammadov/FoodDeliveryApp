package com.yusifmammadov.fooddelivery.presentation.model

import androidx.annotation.DrawableRes


data class RestaurantCarouselItem(
    val id: String = "",
    val title: String = "",
    val restaurants: List<RestaurantItem> = emptyList()
)
data class RestaurantItem(
    val id: String = "",
    @DrawableRes val img: Int,
    val name: String,
    val estimatedDelivery: Int
)
