package com.yusifmammadov.fooddelivery.presentation.onboarding

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusifmammadov.fooddelivery.util.Constants
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(app: Application): AndroidViewModel(app) {

    private val _state = MutableStateFlow<OnboardingScreenState>(OnboardingScreenState())
    val state: StateFlow<OnboardingScreenState> = _state.asStateFlow()


    val sharedPrefs = getApplication<Application>().getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE)

    fun onOnboardingFinished() {
        sharedPrefs
            .edit()
            .putBoolean(Constants.ONBOARDING_FINISHED, true)
            .apply()

        _state.value = OnboardingScreenState(isOnboardingFinished = true)

    }
    
    fun navigatedTo() {
        _state.value = OnboardingScreenState(false)
    }
}
