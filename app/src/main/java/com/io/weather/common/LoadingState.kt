package com.io.weather.common

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
sealed class LoadingState<out R> {
    fun isLoading() = this is Loading
    fun isSuccessful() = this is LoadingSuccess

    override fun toString(): String {
        return when (this) {
            is LoadingSuccess<*> -> "Success[data = $data]"
            is LoadingNoContent -> "Success[reason = $reason]"
            is LoadingError -> "Error[exception = ${error}]"
            Loading -> "Loading"
        }
    }
}

data class LoadingSuccess<out T>(val data: T) : LoadingState<T>()

data class LoadingNoContent(val reason: String) : LoadingState<Nothing>()

data class LoadingError(val error: Throwable) : LoadingState<Nothing>()

object Loading : LoadingState<Nothing>()