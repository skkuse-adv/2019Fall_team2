package com.google.firebase.perf.internal;

import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzcd;

final class zzg implements Runnable {
    private final /* synthetic */ zzbt zzdc;
    private final /* synthetic */ zzc zzdd;
    private final /* synthetic */ zzcd zzde;

    zzg(zzc zzc, zzcd zzcd, zzbt zzbt) {
        this.zzdd = zzc;
        this.zzde = zzcd;
        this.zzdc = zzbt;
    }

    public final void run() {
        this.zzdd.zzb(this.zzde, this.zzdc);
    }
}
