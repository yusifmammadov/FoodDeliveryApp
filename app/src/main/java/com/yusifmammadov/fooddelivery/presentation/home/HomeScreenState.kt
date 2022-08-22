package com.yusifmammadov.fooddelivery.presentation.home

import com.yusifmammadov.fooddelivery.presentation.model.DealItem
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantCarouselItem

data class HomeScreenState(
    val isLoading: Boolean = false,
    val data: List<RestaurantCarouselItem> = emptyList(),
    val deal: DealItem? = null
)
