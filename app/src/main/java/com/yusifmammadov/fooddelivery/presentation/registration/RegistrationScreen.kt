package com.yusifmammadov.fooddelivery.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yusifmammadov.fooddelivery.presentation.components.LogoPattern
import com.yusifmammadov.fooddelivery.ui.theme.FoodDeliveryAppTheme
import com.yusifmammadov.fooddelivery.ui.theme.bentonSans
import com.yusifmammadov.fooddelivery.R
import com.yusifmammadov.fooddelivery.presentation.components.GradientButton
import com.yusifmammadov.fooddelivery.ui.theme.WhiteA

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalComposeUiApi::class)
@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel = viewModel(),
    navigateToHome: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    if (state.isLoading) {
        CircularProgressIndicator()
    }


    if (state.isRegisteredSuccessfully) {
        val currNavigateToHome by rememberUpdatedState(navigateToHome)
        LaunchedEffect(Unit) {
            viewModel.navigatedFrom()
            currNavigateToHome()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        LogoPattern(
            modifier = modifier
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(id = R.string.sign_up_for_free),
                fontFamily = bentonSans,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                lineHeight = 24.sp,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
            )

//            Spacer(modifier = Modifier.heightIn(16.dp, 24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = state.nameValue,
                    onValueChange = {
                        viewModel.onNameValueChanged(it)
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(30),
                    maxLines = 1,
                    placeholder = {
                        Text(text = stringResource(id = R.string.name))
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.9f)
                )

                Spacer(modifier = Modifier.heightIn(8.dp, 24.dp))

                OutlinedTextField(
                    value = state.emailValue,
                    onValueChange = {
                        viewModel.onEmailValueChanged(it)
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(30),
                    maxLines = 1,
                    placeholder = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.9f)
                )

                Spacer(modifier = Modifier.heightIn(8.dp, 24.dp))

                OutlinedTextField(
                    value = state.passwordValue,
                    onValueChange = {
                        viewModel.onPasswordValueChanged(it)
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_lock),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_password),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    isPasswordVisible = !isPasswordVisible
                                }
                        )
                    },
                    shape = RoundedCornerShape(30),
                    maxLines = 1,
                    placeholder = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    visualTransformation = if (isPasswordVisible)VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.9f)
                )
            }



            GradientButton(
                text = R.string.create_account,
                onClick = {
                    viewModel.registerUser()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun RegistrationScreenPreview() {
    FoodDeliveryAppTheme {
        RegistrationScreen(navigateToHome = {})
    }
}