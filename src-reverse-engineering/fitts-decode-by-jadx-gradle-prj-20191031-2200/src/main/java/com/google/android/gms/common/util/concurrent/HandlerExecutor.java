package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zze;
import java.util.concurrent.Executor;

public class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Looper looper) {
        this.handler = new zze(looper);
    }

    public void execute(@NonNull Runnable runnable) {
        this.handler.post(runnable);
    }
}
