package com.stupacki.hilt.app.data.injection

import com.stupacki.hilt.app.data.injection.qualifiers.*
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

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
    fun provideCoroutineDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @CoroutineDispatcherIO
    @Reusable
    fun provideCoroutineDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @CoroutineContextDefault
    @Reusable
    fun provideCoroutineContextDefault(
        @CoroutineDispatcherDefault defaultDispatcher: CoroutineDispatcher,
    ): CoroutineContext = defaultDispatcher + Job()

    @Provides
    @CoroutineContextMain
    @Reusable
    fun provideCoroutineContextMain(
        @CoroutineDispatcherMain mainDispatcher: CoroutineDispatcher,
    ): CoroutineContext = mainDispatcher + Job()

    @Provides
    @CoroutineContextIO
    @Reusable
    fun provideCoroutineContextIO(
        @CoroutineDispatcherIO ioDispatcher: CoroutineDispatcher,
    ): CoroutineContext = ioDispatcher + Job()
}
