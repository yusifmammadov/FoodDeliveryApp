package com.yusifmammadov.fooddelivery.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.GreenA
import com.yusifmammadov.fooddelivery.ui.theme.GreenB
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans

@Composable
fun GradientButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(35),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        modifier = modifier) {
        
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .background(Brush.horizontalGradient(listOf(
                    GreenB, GreenA
                )))
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
            Text(text = stringResource(id = text),
                fontFamily = bentonSans,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                modifier = modifier
                    .padding(
                        start = 22.dp,
                        end = 22.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ))
        }
    }
}

@Composable
@Preview
fun GradientButtonPreview() {
    FoodDeliveryAppTheme() {
        GradientButton(text = R.string.next, onClick = {})
    }

}