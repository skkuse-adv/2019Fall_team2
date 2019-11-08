package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.Callable;

final /* synthetic */ class zzeh implements Callable {
    private final zzei zzke;
    private final zzen zzkf;

    zzeh(zzei zzei, zzen zzen) {
        this.zzke = zzei;
        this.zzkf = zzen;
    }

    public final Object call() {
        return this.zzke.zze(this.zzkf);
    }
}
