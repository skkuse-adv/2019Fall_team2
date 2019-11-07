package com.google.firebase.perf.internal;

import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzda;

final class zze implements Runnable {
    private final /* synthetic */ zzda zzdb;
    private final /* synthetic */ zzbt zzdc;
    private final /* synthetic */ zzc zzdd;

    zze(zzc zzc, zzda zzda, zzbt zzbt) {
        this.zzdd = zzc;
        this.zzdb = zzda;
        this.zzdc = zzbt;
    }

    public final void run() {
        this.zzdd.zzb(this.zzdb, this.zzdc);
    }
}
