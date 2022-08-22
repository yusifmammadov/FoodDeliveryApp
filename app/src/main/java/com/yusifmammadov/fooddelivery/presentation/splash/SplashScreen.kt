package com.yusifmammadov.fooddelivery.presentation.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
    modifier: Modifier = Modifier) {

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
            Column(modifier = modifier.align(Alignment.Center)) {

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

        LaunchedEffect(key1 = true) {
            delay(2000)
            onSplashFinished()
        }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreenPreview() {
    FoodDeliveryAppTheme {
        SplashScreen({})
    }
}

@Composable
@Preview(widthDp = 240, heightDp = 320, showBackground = true)
fun SplashScreenPreview2() {
    FoodDeliveryAppTheme {
        SplashScreen({})
    }
}