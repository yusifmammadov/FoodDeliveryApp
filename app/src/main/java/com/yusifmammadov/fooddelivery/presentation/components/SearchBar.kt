package com.yusifmammadov.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.Orange
import com.yusifmammadov.fooddelivery.ui.theme.OrangeB
import com.yusifmammadov.fooddelivery.ui.theme.OrangeLight

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onSearchIconClicked: () -> Unit

) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        shape = RoundedCornerShape(25),
        leadingIcon = {
            IconButton(onClick = {
                    onSearchIconClicked()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_text)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Orange,
            backgroundColor = OrangeLight.copy(alpha = 0.1f),
            cursorColor = Orange,
            focusedBorderColor = Orange.copy(alpha = ContentAlpha.high),
            unfocusedBorderColor = OrangeLight,
            leadingIconColor = Orange,
            placeholderColor = OrangeB
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
@Preview
fun SearchBarPreview() {
    FoodDeliveryAppTheme() {
        SearchBar(
            value = "Type something",
            onValueChange = {},
            onSearchIconClicked = {}
        )
    }
}