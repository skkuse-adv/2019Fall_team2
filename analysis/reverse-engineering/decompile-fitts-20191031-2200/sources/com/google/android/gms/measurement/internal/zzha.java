package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzha implements Runnable {
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;

    zzha(zzgp zzgp, AtomicReference atomicReference) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
    }

    public final void run() {
        synchronized (this.zzps) {
            try {
                this.zzps.set(Long.valueOf(this.zzpt.zzad().zza(this.zzpt.zzr().zzag(), zzak.zzho)));
                this.zzps.notify();
            } catch (Throwable th) {
                this.zzps.notify();
                throw th;
            }
        }
    }
}
