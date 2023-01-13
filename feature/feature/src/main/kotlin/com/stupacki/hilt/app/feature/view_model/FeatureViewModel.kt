package com.stupacki.hilt.app.feature.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
internal class FeatureViewModel : ViewModel() {

    private var _featureState: Int = 0
    val featureState: Int
        get() = _featureState

    fun inc() {
        _featureState += 1
    }
}
