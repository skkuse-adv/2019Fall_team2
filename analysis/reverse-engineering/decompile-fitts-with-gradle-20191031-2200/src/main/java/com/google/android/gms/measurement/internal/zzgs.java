package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzgs implements Runnable {
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;

    zzgs(zzgp zzgp, AtomicReference atomicReference) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
    }

    public final void run() {
        this.zzpt.zzs().zza(this.zzps);
    }
}
