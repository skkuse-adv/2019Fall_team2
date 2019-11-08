package com.google.android.gms.measurement.internal;

final class zzey implements Runnable {
    private final /* synthetic */ zzfj zzmu;
    private final /* synthetic */ zzef zzmv;

    zzey(zzez zzez, zzfj zzfj, zzef zzef) {
        this.zzmu = zzfj;
        this.zzmv = zzef;
    }

    public final void run() {
        if (this.zzmu.zzht() == null) {
            this.zzmv.zzgk().zzao("Install Referrer Reporter is null");
            return;
        }
        zzeu zzht = this.zzmu.zzht();
        zzht.zzj.zzm();
        zzht.zzat(zzht.zzj.getContext().getPackageName());
    }
}
