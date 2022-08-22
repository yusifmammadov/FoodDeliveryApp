package com.yusifmammadov.fooddelivery.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.model.DealItem
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans

@Composable
fun DealCard(
    modifier: Modifier = Modifier,
    item: DealItem,
    onClicked: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(13f / 6f),
        shape = RoundedCornerShape(16)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = item.img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = item.text,
                    fontFamily = bentonSans,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                Button(
                    onClick = {
                        onClicked()
                    },
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = MaterialTheme.colors.primary
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = item.cta
                    )
                }



            }


        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DealCardPreview() {
    FoodDeliveryAppTheme() {
        DealCard(
            item = DealItem(
                R.drawable.deal_img,
                text = "Lorepm something medium long",
                cta = "Buy Now"
            ),
            onClicked = {}
        )
    }
}