package com.stupacki.hilt.app.data.injection.qualifiers

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

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineContextDefault

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineContextMain

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoroutineContextIO