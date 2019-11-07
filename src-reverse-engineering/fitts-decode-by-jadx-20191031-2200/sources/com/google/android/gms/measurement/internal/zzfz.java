package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzfz implements Callable<byte[]> {
    private final /* synthetic */ zzai zzdm;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ zzfk zzph;

    zzfz(zzfk zzfk, zzai zzai, String str) {
        this.zzph = zzfk;
        this.zzdm = zzai;
        this.zzdn = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzph.zzkz.zzjq();
        return this.zzph.zzkz.zzji().zzb(this.zzdm, this.zzdn);
    }
}
