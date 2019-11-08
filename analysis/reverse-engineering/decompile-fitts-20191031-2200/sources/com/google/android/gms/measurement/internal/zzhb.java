package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhb implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ boolean zzbi;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;
    private final /* synthetic */ String zzx;

    zzhb(zzgp zzgp, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
        this.zzdn = str;
        this.zzx = str2;
        this.zzas = str3;
        this.zzbi = z;
    }

    public final void run() {
        this.zzpt.zzj.zzs().zza(this.zzps, this.zzdn, this.zzx, this.zzas, this.zzbi);
    }
}
