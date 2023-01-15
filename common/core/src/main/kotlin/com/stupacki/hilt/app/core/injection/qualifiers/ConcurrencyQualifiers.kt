package com.stupacki.hilt.app.core.injection.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineDispatcherDefault

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineDispatcherMain

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineDispatcherIO