package com.google.firebase.perf.internal;

import com.google.android.gms.internal.firebase-perf.zzbt;

final /* synthetic */ class zzo implements Runnable {
    private final GaugeManager zzdk;
    private final String zzdl;
    private final zzbt zzdm;

    zzo(GaugeManager gaugeManager, String str, zzbt zzbt) {
        this.zzdk = gaugeManager;
        this.zzdl = str;
        this.zzdm = zzbt;
    }

    public final void run() {
        this.zzdk.zzd(this.zzdl, this.zzdm);
    }
}
