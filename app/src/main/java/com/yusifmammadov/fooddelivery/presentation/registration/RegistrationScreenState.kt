package com.yusifmammadov.fooddelivery.presentation.registration

data class RegistrationScreenState(
    val isLoading: Boolean = false,
    val nameValue: String = "",
    val emailValue: String = "",
    val passwordValue: String = "",
    val isRegisteredSuccessfully: Boolean = false
)