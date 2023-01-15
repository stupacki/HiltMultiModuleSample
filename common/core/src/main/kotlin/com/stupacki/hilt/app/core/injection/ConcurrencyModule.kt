package com.stupacki.hilt.app.core.injection

import com.stupacki.hilt.app.core.injection.qualifiers.CoroutineDispatcherDefault
import com.stupacki.hilt.app.core.injection.qualifiers.CoroutineDispatcherIO
import com.stupacki.hilt.app.core.injection.qualifiers.CoroutineDispatcherMain
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object ConcurrencyModule {

    @Provides
    @CoroutineDispatcherDefault
    @Reusable
    fun provideCoroutineDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @CoroutineDispatcherMain
    @Reusable
    fun provideCoroutineDispatcherUi(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @CoroutineDispatcherIO
    @Reusable
    fun provideCoroutineDispatcherIo(): CoroutineDispatcher = Dispatchers.IO
}
