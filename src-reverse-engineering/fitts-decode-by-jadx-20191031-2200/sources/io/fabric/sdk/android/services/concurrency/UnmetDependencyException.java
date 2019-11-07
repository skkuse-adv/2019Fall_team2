package io.fabric.sdk.android.services.concurrency;

public class UnmetDependencyException extends RuntimeException {
    public UnmetDependencyException() {
    }

    public UnmetDependencyException(String str) {
        super(str);
    }

    public UnmetDependencyException(String str, Throwable th) {
        super(str, th);
    }

    public UnmetDependencyException(Throwable th) {
        super(th);
    }
}
