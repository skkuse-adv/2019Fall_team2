package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzgz implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;
    private final /* synthetic */ String zzx;

    zzgz(zzgp zzgp, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
        this.zzdn = str;
        this.zzx = str2;
        this.zzas = str3;
    }

    public final void run() {
        this.zzpt.zzj.zzs().zza(this.zzps, this.zzdn, this.zzx, this.zzas);
    }
}
