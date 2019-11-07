package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzfs implements Callable<List<zzq>> {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzfk zzph;
    private final /* synthetic */ String zzx;

    zzfs(zzfk zzfk, zzn zzn, String str, String str2) {
        this.zzph = zzfk;
        this.zzpg = zzn;
        this.zzx = str;
        this.zzas = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzph.zzkz.zzjq();
        return this.zzph.zzkz.zzgy().zzb(this.zzpg.packageName, this.zzx, this.zzas);
    }
}
