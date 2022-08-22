package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import kotlinx.coroutines.delay

@Composable
fun LogoPattern(
    modifier: Modifier = Modifier
) {

    Box (modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pattern),
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            contentScale = ContentScale.None,
            alignment = Alignment.BottomCenter,
            contentDescription = null)

        Box(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.55f)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0f),
                        Color.White
                    )
                )
            )
        )
        Column(
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                        //Png file's borders are not symmetrical, so I had to use a workaround like this
                    .padding(start = 6.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo_app_name),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            )
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun LogoPatternPreview() {
    FoodDeliveryAppTheme {
        LogoPattern()
    }
}