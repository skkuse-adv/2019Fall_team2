package com.google.android.gms.measurement.internal;

final class zze implements Runnable {
    private final /* synthetic */ zza zzcc;
    private final /* synthetic */ long zzcd;

    zze(zza zza, long j) {
        this.zzcc = zza;
        this.zzcd = j;
    }

    public final void run() {
        this.zzcc.zzd(this.zzcd);
    }
}
