package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.model.RestaurantItem
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RestauranCard(
    modifier: Modifier = Modifier,
    restaurant: RestaurantItem,
    onClick: (String) -> Unit
) {

    Card(
        modifier = modifier
            .width(140.dp)
            .height(180.dp),
        shape = RoundedCornerShape(20),
        onClick = {
            onClick(restaurant.id)
        },
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            
            Image(
                painter = painterResource(id = restaurant.img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                
                Text(
                    text = restaurant.name,
                    fontFamily = bentonSans,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${restaurant.estimatedDelivery} Min",
                    fontFamily = bentonSans,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }




            
        }
    }

}

@Composable
@Preview
fun RestaurantCardPreview() {
    FoodDeliveryAppTheme() {
        RestauranCard(
            restaurant = RestaurantItem(
            img = R.drawable.rest_1,
            name = "Vegan Resto",
            estimatedDelivery = 12
            ),
            onClick = {}
        )
    }
}