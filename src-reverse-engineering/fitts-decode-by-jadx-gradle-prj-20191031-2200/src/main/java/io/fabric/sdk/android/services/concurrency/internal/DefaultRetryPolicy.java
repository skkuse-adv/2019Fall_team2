package io.fabric.sdk.android.services.concurrency.internal;

public class DefaultRetryPolicy implements RetryPolicy {
    private final int maxRetries;

    public DefaultRetryPolicy() {
        this(1);
    }

    public DefaultRetryPolicy(int i) {
        this.maxRetries = i;
    }

    public boolean shouldRetry(int i, Throwable th) {
        return i < this.maxRetries;
    }
}
