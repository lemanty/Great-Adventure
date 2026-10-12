package com.lemanty.greatadventure.data.repository;

/** A repository implementation must cancel its underlying network call too. */
public interface RequestHandle {
    /** Idempotent. Once cancelled, no pending result callback may be delivered. */
    void cancel();
}
