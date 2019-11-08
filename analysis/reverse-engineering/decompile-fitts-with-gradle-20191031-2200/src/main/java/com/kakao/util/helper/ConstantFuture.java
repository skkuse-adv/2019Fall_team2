package com.kakao.util.helper;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ConstantFuture<T> implements Future<T> {
    private final T v;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public ConstantFuture(T t) {
        this.v = t;
    }

    public T get() {
        return this.v;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.v;
    }
}
