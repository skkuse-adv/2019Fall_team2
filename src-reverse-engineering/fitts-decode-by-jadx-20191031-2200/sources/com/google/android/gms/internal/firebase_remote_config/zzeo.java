package com.google.android.gms.internal.firebase_remote_config;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzeo<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    private final CountDownLatch zzku;

    private zzeo() {
        this.zzku = new CountDownLatch(1);
    }

    public final void onSuccess(TResult tresult) {
        this.zzku.countDown();
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zzku.countDown();
    }

    public final void onCanceled() {
        this.zzku.countDown();
    }

    public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.zzku.await(5, timeUnit);
    }
}
