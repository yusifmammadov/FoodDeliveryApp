package com.yusifmammadov.fooddelivery.presentation.registration


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationViewModel: ViewModel() {

    private val _state = MutableStateFlow(RegistrationScreenState())
    val state: StateFlow<RegistrationScreenState> = _state.asStateFlow()



    fun onNameValueChanged(s: String) {
        _state.value = _state.value.copy(
            nameValue = s
        )
    }

    fun onEmailValueChanged(s: String) {
        _state.value = _state.value.copy(
            emailValue = s
        )
    }

    fun onPasswordValueChanged(s: String) {
        _state.value = _state.value.copy(
            passwordValue = s
        )
    }

    fun registerUser() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            withContext(Dispatchers.IO) {
                delay(800)
                _state.value = _state.value.copy(
                    isLoading = false,
                    isRegisteredSuccessfully = true
                )
            }

        }
    }

    fun navigatedFrom() {
        _state.value = _state.value.copy(
            isRegisteredSuccessfully = false
        )
    }

}