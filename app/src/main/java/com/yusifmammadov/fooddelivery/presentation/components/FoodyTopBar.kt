package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans
import com.yusifmammadov.fooddelivery.util.gradientBackground

@Composable
fun FoodyTopBar(
    modifier: Modifier = Modifier,
    onNotificationIconClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pattern),
            contentDescription = null,
            modifier = Modifier
                .layout { measurable, constraints ->
                    if (constraints.maxHeight == Constraints.Infinity) {
                        layout(0,0) {}
                    } else {
                        val placeable = measurable.measure(constraints)
                        layout(placeable.width, placeable.height) {
                            placeable.place(0,0)
                        }
                    }
                },
            contentScale = ContentScale.None,
            alignment = Alignment.BottomCenter
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .gradientBackground(
                    colors = listOf(
                        Color.White,
                        Color.White.copy(alpha = 0f)
                    ),
                    angle = 85f
                )
                .padding(vertical = 24.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = stringResource(id = R.string.find_fav_food),
                fontFamily = bentonSans,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                lineHeight = 32.sp,
                modifier = Modifier
                    //.padding(vertical = 24.dp, horizontal = 16.dp)
            )
            
            NotificationIcon(
                onClick = {
                onNotificationIconClicked()
            },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            

        }
    }
}


@Composable
@Preview()
fun FoodyTopBarPreview() {
    FoodDeliveryAppTheme {
        FoodyTopBar(onNotificationIconClicked = {})
    }
}