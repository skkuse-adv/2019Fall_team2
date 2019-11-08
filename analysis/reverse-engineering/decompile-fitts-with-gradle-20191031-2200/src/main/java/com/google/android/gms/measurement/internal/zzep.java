package com.google.android.gms.measurement.internal;

final class zzep implements Runnable {
    private final /* synthetic */ boolean zzmf;
    private final /* synthetic */ zzem zzmg;

    zzep(zzem zzem, boolean z) {
        this.zzmg = zzem;
        this.zzmf = z;
    }

    public final void run() {
        this.zzmg.zzkz.zzj(this.zzmf);
    }
}
