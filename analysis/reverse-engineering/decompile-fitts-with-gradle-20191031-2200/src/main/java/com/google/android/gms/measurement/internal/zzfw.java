package com.google.android.gms.measurement.internal;

final class zzfw implements Runnable {
    private final /* synthetic */ zzai zzdm;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ zzfk zzph;

    zzfw(zzfk zzfk, zzai zzai, String str) {
        this.zzph = zzfk;
        this.zzdm = zzai;
        this.zzdn = str;
    }

    public final void run() {
        this.zzph.zzkz.zzjq();
        this.zzph.zzkz.zzd(this.zzdm, this.zzdn);
    }
}
