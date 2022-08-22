package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantCarouselItem
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantItem
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.OrangeC
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans


@Composable
fun RestaurantCarousel(
    modifier: Modifier = Modifier,
    carouselItem: RestaurantCarouselItem,
    onViewMoreClicked: () -> Unit,
    onItemClicked: (String) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = carouselItem.title,
                fontFamily = bentonSans,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                maxLines = 1,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            TextButton(
                onClick = {
                    onViewMoreClicked()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = OrangeC
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                contentPadding = PaddingValues(
                    horizontal = 0.dp,
                    vertical = 8.dp
                )
            ) {
                Text(text = stringResource(id = R.string.view_more))
            }
        }

        Spacer(modifier = Modifier
            .heightIn(16.dp, 24.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            items(carouselItem.restaurants) { restaurant ->

                RestauranCard(
                    restaurant = restaurant,
                    onClick = {
                        onItemClicked(it)
                    }
                )
            }
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun RestaurantCarouselPreview() {
    FoodDeliveryAppTheme() {
        RestaurantCarousel(
            carouselItem = RestaurantCarouselItem(
                title = "Nearest Restaurants",
                restaurants = restaurants
            ),
            onViewMoreClicked = {},
            onItemClicked = {}
        )
    }
}

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