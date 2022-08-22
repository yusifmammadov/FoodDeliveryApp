package com.yusifmammadov.fooddelivery.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yusifmammadov.fooddelivery.presentation.components.DealCard
import com.yusifmammadov.fooddelivery.presentation.components.FoodyTopBar
import com.yusifmammadov.fooddelivery.presentation.components.RestaurantCarousel
import com.yusifmammadov.fooddelivery.presentation.components.SearchBar
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isLoading) {
        CircularProgressIndicator()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        FoodyTopBar(
            onNotificationIconClicked = {

            }
        )

        Spacer(
            modifier = modifier
                .heightIn(16.dp, 32.dp)
        )

        SearchBar(
            value = "",
            onValueChange = {},
            onSearchIconClicked = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)

        )

        LazyColumn(
            modifier = modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                state.deal?.let {
                    DealCard(
                        item = it,
                        onClicked = {},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 16.dp)
                    )
                }
            }

            items(state.data) { carousel ->
                RestaurantCarousel(
                    carouselItem = carousel,
                    onViewMoreClicked = {  },
                    onItemClicked = {  }
                )
            }
        }


    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    FoodDeliveryAppTheme {
        HomeScreen()
    }
}