package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class zzb implements ThreadFactory {
    static final ThreadFactory zza = new zzb();

    private zzb() {
    }

    public final Thread newThread(Runnable runnable) {
        return zzc.zza(runnable);
    }
}
