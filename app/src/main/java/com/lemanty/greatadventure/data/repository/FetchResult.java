package com.lemanty.greatadventure.data.repository;

import java.util.Objects;

/** A successful response (possibly empty) or an expected service failure. */
public interface FetchResult<T> {
    final class Success<T> implements FetchResult<T> {
        private final T data;
        private final long fetchedAtEpochMillis;
        private final boolean cached;

        public Success(T data, long fetchedAtEpochMillis) {
            this(data, fetchedAtEpochMillis, false);
        }

        public Success(T data, long fetchedAtEpochMillis, boolean cached) {
            this.data = Objects.requireNonNull(data);
            this.fetchedAtEpochMillis = fetchedAtEpochMillis;
            this.cached = cached;
        }

        public T getData() { return data; }
        public long getFetchedAtEpochMillis() { return fetchedAtEpochMillis; }
        public boolean isCached() { return cached; }
    }

    final class Failure<T> implements FetchResult<T> {
        private final Reason reason;

        public Failure(Reason reason) {
            this.reason = Objects.requireNonNull(reason);
        }

        public Reason getReason() { return reason; }
    }

    enum Reason { NETWORK, TIMEOUT, UNAUTHORIZED, SERVICE, INVALID_RESPONSE }
}
