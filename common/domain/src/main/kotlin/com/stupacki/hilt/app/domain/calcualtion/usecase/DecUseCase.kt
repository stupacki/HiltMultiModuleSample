package com.stupacki.hilt.app.domain.calcualtion.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DecUseCase(
    private val ioDispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(count: Int) = withContext(ioDispatcher) {
        count - 1
    }
}
