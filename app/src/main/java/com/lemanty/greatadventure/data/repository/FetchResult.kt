package com.lemanty.greatadventure.data.repository

sealed interface FetchResult<out T> {
    data class Success<T>(
        val data: T,
        val fetchedAtEpochMillis: Long,
        val isCached: Boolean = false,
    ) : FetchResult<T>

    data class Failure(val reason: Reason) : FetchResult<Nothing>

    enum class Reason { NETWORK, TIMEOUT, UNAUTHORIZED, SERVICE, INVALID_RESPONSE }
}
