package com.google.android.gms.internal.measurement;

final class zzcu<T> extends zzcw<T> {
    static final zzcu<Object> zzabp = new zzcu<>();

    private zzcu() {
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
