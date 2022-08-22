package com.yusifmammadov.fooddelivery.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.model.DealItem
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantCarouselItem
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantItem
import com.yusifmammadov.fooddelivery.presentation.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    private val deal = DealItem(
        img = R.drawable.deal_img,
        text = "Special Deal For October",
        cta = "Buy Now"
    )

    private val restaurants = listOf(
        RestaurantItem(
            img = R.drawable.rest_1,
            name = "Vegan Resto",
            estimatedDelivery = 12
        ),
        RestaurantItem(
            img = R.drawable.rest_2,
            name = "Healthy Food",
            estimatedDelivery = 16
        ),
        RestaurantItem(
            img = R.drawable.rest_3,
            name = "Good Food",
            estimatedDelivery = 8
        ),
        RestaurantItem(
            img = R.drawable.rest_4,
            name = "Smart Resto",
            estimatedDelivery = 19
        ),
        RestaurantItem(
            img = R.drawable.rest_5,
            name = "Tasty Resto",
            estimatedDelivery = 14
        ),
        RestaurantItem(
            img = R.drawable.rest_6,
            name = "Chef's Resto",
            estimatedDelivery = 11
        )
    )

    private val carousels = listOf(
        RestaurantCarouselItem(
            title = "Nearest Restaurants",
            restaurants = restaurants
        ),
        RestaurantCarouselItem(
            title = "Popular Restaurants",
            restaurants = restaurants.asReversed()
        ),
        RestaurantCarouselItem(
            title = "Featured Restaurants",
            restaurants = restaurants.shuffled()
        )
    )

    init {
        getRestaurants()
    }

    fun getRestaurants() = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true)
        withContext(Dispatchers.IO) {
            delay(800)
            _state.value = _state.value.copy(
                isLoading = false,
                deal = deal,
                data = carousels
            )
        }
    }
}