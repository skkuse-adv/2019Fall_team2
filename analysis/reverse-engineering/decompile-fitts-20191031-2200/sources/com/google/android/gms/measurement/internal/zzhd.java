package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhd implements Runnable {
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;

    zzhd(zzgp zzgp, AtomicReference atomicReference) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
    }

    public final void run() {
        synchronized (this.zzps) {
            try {
                this.zzps.set(Integer.valueOf(this.zzpt.zzad().zzb(this.zzpt.zzr().zzag(), zzak.zzhp)));
                this.zzps.notify();
            } catch (Throwable th) {
                this.zzps.notify();
                throw th;
            }
        }
    }
}
