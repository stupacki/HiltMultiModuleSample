package com.stupacki.hilt.app.domain.calcualtion.usecase

import com.stupacki.hilt.app.data.injection.qualifiers.CoroutineDispatcherIO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DecUseCase @Inject constructor(
    @CoroutineDispatcherIO private val ioDispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(count: Int) = withContext(ioDispatcher) {
        count - 1
    }
}
