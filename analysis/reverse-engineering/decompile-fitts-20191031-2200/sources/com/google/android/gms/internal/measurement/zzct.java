package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

public final class zzct {
    /* access modifiers changed from: private */
    public final Uri zzabh;
    /* access modifiers changed from: private */
    public final String zzabi;
    /* access modifiers changed from: private */
    public final String zzabj;

    public zzct(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzct(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzcx<Context, Boolean> zzcx) {
        this.zzabh = uri;
        this.zzabi = str2;
        this.zzabj = str3;
    }

    public final zzcm<Long> zze(String str, long j) {
        return zzcm.zza(this, str, j);
    }

    public final zzcm<Boolean> zzb(String str, boolean z) {
        return zzcm.zza(this, str, z);
    }

    public final zzcm<Double> zza(String str, double d) {
        return zzcm.zza(this, str, -3.0d);
    }

    public final zzcm<String> zzt(String str, String str2) {
        return zzcm.zza(this, str, str2);
    }
}
