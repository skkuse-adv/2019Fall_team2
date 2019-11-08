package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    public abstract void onSuccess(@NonNull R r);

    public final void onResult(@NonNull R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(r);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                sb.toString();
            }
        }
    }
}
