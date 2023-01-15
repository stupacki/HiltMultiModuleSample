package com.stupacki.hilt.app.domain.calcualtion.injection

import com.stupacki.hilt.app.domain.calcualtion.usecase.DecUseCase
import com.stupacki.hilt.app.domain.calcualtion.usecase.IncUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CalculationDependencies {

    fun incUseCase(ioDispatcher: CoroutineDispatcher): IncUseCase
    fun decUseCase(ioDispatcher: CoroutineDispatcher): DecUseCase
}
