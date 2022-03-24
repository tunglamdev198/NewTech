package com.lamnt.newtech.domain.usecases

import com.lamnt.newtech.presentation.model.Resource
import kotlinx.coroutines.flow.flow

open class BaseUseCase {
    fun <T> handle(source: suspend () -> T) = flow {
        emit(Resource.loading())
        try {
            val result = source()
            emit(Resource.success(result))
        } catch (e: Exception) {
            emit(Resource.error(e.message!!))
        }

    }
}