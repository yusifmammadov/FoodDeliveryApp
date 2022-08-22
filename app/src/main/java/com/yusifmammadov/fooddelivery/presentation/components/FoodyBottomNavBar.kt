package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yusifmammadov.fooddelivery.presentation.navigation.Screen
import java.util.*

@Composable
fun FoodyBottomNavBar(
    screens: List<Screen>,
    onSelected: (String) -> Unit,
    currentScreen: String
) {

    Surface(
        shape = RoundedCornerShape(20),
        elevation = 4.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            modifier = Modifier
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            screens.forEach { screen ->
                BottomNavBarItem(
                    screen = screen,
                    selected = screen.route == currentScreen,
                    onSelected = {
                        onSelected(it)
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavBarItem(
    screen: Screen,
    selected: Boolean,
    onSelected: (String) -> Unit
) {
    val color = MaterialTheme.colors.primary
    val durationMillis = if (selected) 150 else 100
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = 100
        )
    }
    val tintColor by animateColorAsState(
        targetValue = if (selected) color else color.copy(alpha = 0.6f),
        animationSpec = animSpec
    )

    Row(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(56.dp)
            .selectable(
                selected = selected,
                onClick = {
                    onSelected(screen.route)
                },
                role = Role.Tab,
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Unspecified
                ),
                interactionSource = remember {
                    MutableInteractionSource()
                }
            )
    ) {
        Icon(
            painter = painterResource(id = screen.icon),
            contentDescription = screen.title,
            tint = tintColor
        )
        if (selected) {
            Spacer(Modifier.width(12.dp))
            Text(screen.title, color = tintColor)
        }
    }

}