package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzgw implements Runnable {
    private final /* synthetic */ zzgp zzpt;
    private final /* synthetic */ Bundle zzqg;

    zzgw(zzgp zzgp, Bundle bundle) {
        this.zzpt = zzgp;
        this.zzqg = bundle;
    }

    public final void run() {
        this.zzpt.zzf(this.zzqg);
    }
}
