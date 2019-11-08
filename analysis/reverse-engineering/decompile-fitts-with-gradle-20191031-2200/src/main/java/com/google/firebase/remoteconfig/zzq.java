package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzfd;
import java.util.concurrent.Callable;

final /* synthetic */ class zzq implements Callable {
    private final zzfd zzkc;

    private zzq(zzfd zzfd) {
        this.zzkc = zzfd;
    }

    static Callable zza(zzfd zzfd) {
        return new zzq(zzfd);
    }

    public final Object call() {
        return Boolean.valueOf(this.zzkc.zzdg());
    }
}
