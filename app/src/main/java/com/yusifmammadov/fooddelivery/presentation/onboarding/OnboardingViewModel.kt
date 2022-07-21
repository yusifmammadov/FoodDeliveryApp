package com.yusifmammadov.fooddelivery.presentation.onboarding

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.yusifmammadov.fooddelivery.util.Constants

class OnboardingViewModel(app: Application): AndroidViewModel(app) {

    val sharedPrefs = getApplication<Application>().getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE)

    fun onOnboardingFinished() {
        sharedPrefs
            .edit()
            .putBoolean(Constants.ONBOARDING_FINISHED, true)
            .apply()
    }
}