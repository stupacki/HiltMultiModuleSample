package com.stupacki.hilt.app.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupacki.hilt.app.domain.calcualtion.usecase.DecUseCase
import com.stupacki.hilt.app.domain.calcualtion.usecase.IncUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
internal class FeatureViewModel @Inject constructor(
    private val inc: IncUseCase,
    private val dec: DecUseCase,
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    private val _featureState: MutableStateFlow<Int> by lazy { MutableStateFlow(0) }
    val featureState: StateFlow<Int>
        get() = _featureState.asStateFlow()

    fun onIncClicked() {
        launch {
            _featureState.value = inc(_featureState.value)
        }
    }

    fun dec() {
        launch {
            _featureState.value = dec(_featureState.value)
        }
    }
}
