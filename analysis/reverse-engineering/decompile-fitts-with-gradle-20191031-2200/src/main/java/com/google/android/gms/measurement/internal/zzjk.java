package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzjk implements Callable<String> {
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzjg zztl;

    zzjk(zzjg zzjg, zzn zzn) {
        this.zztl = zzjg;
        this.zzpg = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzf zza = this.zztl.zzg(this.zzpg);
        if (zza != null) {
            return zza.getAppInstanceId();
        }
        this.zztl.zzab().zzgn().zzao("App info was null when attempting to get app instance id");
        return null;
    }
}
