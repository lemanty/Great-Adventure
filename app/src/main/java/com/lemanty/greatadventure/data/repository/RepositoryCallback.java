package com.lemanty.greatadventure.data.repository;

/** Deliver at most one result on the main thread, unless the request is cancelled. */
@FunctionalInterface
public interface RepositoryCallback<T> {
    void onResult(FetchResult<T> result);
}
