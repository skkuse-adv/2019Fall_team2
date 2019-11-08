package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzgy implements Runnable {
    private final /* synthetic */ AtomicReference zzps;
    private final /* synthetic */ zzgp zzpt;

    zzgy(zzgp zzgp, AtomicReference atomicReference) {
        this.zzpt = zzgp;
        this.zzps = atomicReference;
    }

    public final void run() {
        synchronized (this.zzps) {
            try {
                this.zzps.set(this.zzpt.zzad().zzp(this.zzpt.zzr().zzag()));
                this.zzps.notify();
            } catch (Throwable th) {
                this.zzps.notify();
                throw th;
            }
        }
    }
}
