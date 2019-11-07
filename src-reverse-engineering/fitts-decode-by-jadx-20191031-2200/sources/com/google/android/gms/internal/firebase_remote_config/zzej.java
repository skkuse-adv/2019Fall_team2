package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.Callable;

final /* synthetic */ class zzej implements Callable {
    private final zzex zzkl;

    private zzej(zzex zzex) {
        this.zzkl = zzex;
    }

    static Callable zza(zzex zzex) {
        return new zzej(zzex);
    }

    public final Object call() {
        return this.zzkl.zzdb();
    }
}
