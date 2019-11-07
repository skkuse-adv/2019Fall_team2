package com.google.android.gms.measurement.internal;

final class zzgc implements Runnable {
    private final /* synthetic */ String zzax;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ zzfk zzph;
    private final /* synthetic */ String zzpj;
    private final /* synthetic */ long zzpk;

    zzgc(zzfk zzfk, String str, String str2, String str3, long j) {
        this.zzph = zzfk;
        this.zzpj = str;
        this.zzdn = str2;
        this.zzax = str3;
        this.zzpk = j;
    }

    public final void run() {
        String str = this.zzpj;
        if (str == null) {
            this.zzph.zzkz.zzjt().zzt().zza(this.zzdn, (zzhr) null);
            return;
        }
        this.zzph.zzkz.zzjt().zzt().zza(this.zzdn, new zzhr(this.zzax, str, this.zzpk));
    }
}
