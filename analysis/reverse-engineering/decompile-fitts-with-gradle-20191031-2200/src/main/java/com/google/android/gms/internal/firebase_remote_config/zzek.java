package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzek implements SuccessContinuation {
    private final zzei zzke;
    private final boolean zzkm;
    private final zzen zzkn;

    zzek(zzei zzei, boolean z, zzen zzen) {
        this.zzke = zzei;
        this.zzkm = z;
        this.zzkn = zzen;
    }

    public final Task then(Object obj) {
        return this.zzke.zza(this.zzkm, this.zzkn, (Void) obj);
    }
}
