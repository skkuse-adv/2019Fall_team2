package com.google.firebase.perf.internal;

import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzci;

final class zzh implements Runnable {
    private final /* synthetic */ zzbt zzdc;
    private final /* synthetic */ zzc zzdd;
    private final /* synthetic */ zzci zzdf;

    zzh(zzc zzc, zzci zzci, zzbt zzbt) {
        this.zzdd = zzc;
        this.zzdf = zzci;
        this.zzdc = zzbt;
    }

    public final void run() {
        this.zzdd.zzb(this.zzdf, this.zzdc);
    }
}
