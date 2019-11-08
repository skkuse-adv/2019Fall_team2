package io.fabric.sdk.android;

public class InitializationException extends RuntimeException {
    public InitializationException(String str) {
        super(str);
    }

    public InitializationException(String str, Throwable th) {
        super(str, th);
    }
}
