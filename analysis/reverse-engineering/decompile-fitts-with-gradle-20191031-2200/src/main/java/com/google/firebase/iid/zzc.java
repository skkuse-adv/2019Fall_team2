package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzc {
    private static final Executor zza = zze.zza;

    static Executor zza() {
        return zza;
    }

    static Executor zzb() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzb.zza);
        return threadPoolExecutor;
    }

    static final /* synthetic */ Thread zza(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }
}
