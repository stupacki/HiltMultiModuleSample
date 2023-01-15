package com.stupacki.hilt.app.injection

import com.stupacki.hilt.app.domain.calcualtion.usecase.DecUseCase
import com.stupacki.hilt.app.domain.calcualtion.usecase.IncUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CommonDependencies {

    /* <--  DOMAIN  --> */

    //Calculation
    fun incUseCase(): IncUseCase
    fun decUseCase(): DecUseCase
}
