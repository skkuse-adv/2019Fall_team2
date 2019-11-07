package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.android.gms.internal.firebase-perf.zzcn;
import java.util.concurrent.TimeUnit;

final class zzu {
    private static final long zzej = TimeUnit.MINUTES.toMicros(1);
    private final boolean zzeg;
    private long zzek;
    private long zzel;
    private zzbg zzem = new zzbg();
    private long zzen;
    private long zzeo;
    private long zzep;
    private long zzeq;
    private long zzer;

    zzu(long j, long j2, zzax zzax, RemoteConfigManager remoteConfigManager, zzv zzv, boolean z) {
        this.zzek = j2;
        this.zzel = j;
        this.zzen = j2;
        long zzc = remoteConfigManager.zzc(zzv.zzbv(), 0);
        if (zzc == 0) {
            zzc = (long) zzv.zzbr();
        }
        long zzc2 = remoteConfigManager.zzc(zzv.zzbw(), (long) zzv.zzbs());
        this.zzeo = zzc2 / zzc;
        this.zzep = zzc2;
        if (!(this.zzep == ((long) zzv.zzbs()) && this.zzeo == ((long) (zzv.zzbs() / zzv.zzbr())))) {
            String.format("Foreground %s logging rate:%d, burst capacity:%d", new Object[]{zzv.toString(), Long.valueOf(this.zzeo), Long.valueOf(this.zzep)});
        }
        long zzc3 = remoteConfigManager.zzc(zzv.zzbx(), 0);
        if (zzc3 == 0) {
            zzc3 = (long) zzv.zzbt();
        }
        long zzc4 = remoteConfigManager.zzc(zzv.zzby(), (long) zzv.zzbu());
        this.zzeq = zzc4 / zzc3;
        this.zzer = zzc4;
        if (!(this.zzer == ((long) zzv.zzbu()) && this.zzeq == ((long) (zzv.zzbu() / zzv.zzbt())))) {
            String.format("Background %s logging rate:%d, capacity:%d", new Object[]{zzv.toString(), Long.valueOf(this.zzeq), Long.valueOf(this.zzer)});
        }
        this.zzeg = z;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized boolean zzb(@NonNull zzcn zzcn) {
        zzbg zzbg = new zzbg();
        this.zzen = Math.min(this.zzen + Math.max(0, (this.zzem.zza(zzbg) * this.zzel) / zzej), this.zzek);
        if (this.zzen > 0) {
            this.zzen--;
            this.zzem = zzbg;
            return true;
        }
        boolean z = this.zzeg;
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zzb(boolean z) {
        this.zzel = z ? this.zzeo : this.zzeq;
        this.zzek = z ? this.zzep : this.zzer;
    }
}
