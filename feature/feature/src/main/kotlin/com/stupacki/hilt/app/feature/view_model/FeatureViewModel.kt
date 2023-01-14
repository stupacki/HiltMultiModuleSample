package com.stupacki.hilt.app.feature.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class FeatureViewModel @Inject constructor() : ViewModel() {

    private val _featureState: MutableStateFlow<Int> by lazy { MutableStateFlow(0) }
    val featureState: StateFlow<Int>
        get() = _featureState.asStateFlow()

    fun inc() {
        _featureState.value += 1
    }
}
