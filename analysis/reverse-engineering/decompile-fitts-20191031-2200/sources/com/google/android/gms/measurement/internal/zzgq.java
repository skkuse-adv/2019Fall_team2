package com.google.android.gms.measurement.internal;

final class zzgq implements Runnable {
    private final /* synthetic */ String zzbn;
    private final /* synthetic */ zzgp zzpt;
    private final /* synthetic */ Object zzqa;
    private final /* synthetic */ long zzqb;
    private final /* synthetic */ String zzx;

    zzgq(zzgp zzgp, String str, String str2, Object obj, long j) {
        this.zzpt = zzgp;
        this.zzx = str;
        this.zzbn = str2;
        this.zzqa = obj;
        this.zzqb = j;
    }

    public final void run() {
        this.zzpt.zza(this.zzx, this.zzbn, this.zzqa, this.zzqb);
    }
}
