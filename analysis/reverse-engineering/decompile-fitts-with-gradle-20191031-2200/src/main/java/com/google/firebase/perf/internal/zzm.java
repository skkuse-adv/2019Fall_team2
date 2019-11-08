package com.google.firebase.perf.internal;

import com.google.android.gms.internal.firebase-perf.zzbt;

final /* synthetic */ class zzm implements Runnable {
    private final GaugeManager zzdk;
    private final String zzdl;
    private final zzbt zzdm;

    zzm(GaugeManager gaugeManager, String str, zzbt zzbt) {
        this.zzdk = gaugeManager;
        this.zzdl = str;
        this.zzdm = zzbt;
    }

    public final void run() {
        this.zzdk.zze(this.zzdl, this.zzdm);
    }
}
