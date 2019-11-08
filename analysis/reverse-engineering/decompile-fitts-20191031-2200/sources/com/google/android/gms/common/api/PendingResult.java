package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    public interface StatusListener {
        void onComplete(Status status);
    }

    @NonNull
    public abstract R await();

    @NonNull
    public abstract R await(long j, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit);

    public void addStatusListener(@NonNull StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Integer zam() {
        throw new UnsupportedOperationException();
    }
}
