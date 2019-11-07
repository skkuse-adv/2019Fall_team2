package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzae {
    final String name;
    final String zzce;
    final long zzfg;
    final long zzfh;
    final long zzfi;
    final long zzfj;
    final long zzfk;
    final Long zzfl;
    final Long zzfm;
    final Long zzfn;
    final Boolean zzfo;

    zzae(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        long j6 = j;
        long j7 = j2;
        long j8 = j3;
        long j9 = j5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j6 >= 0);
        Preconditions.checkArgument(j7 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        if (j9 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzce = str;
        this.name = str2;
        this.zzfg = j6;
        this.zzfh = j7;
        this.zzfi = j8;
        this.zzfj = j4;
        this.zzfk = j9;
        this.zzfl = l;
        this.zzfm = l2;
        this.zzfn = l3;
        this.zzfo = bool;
    }

    zzae(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, j, j2, 0, j3, 0, null, null, null, null);
    }

    /* access modifiers changed from: 0000 */
    public final zzae zzw(long j) {
        zzae zzae = new zzae(this.zzce, this.name, this.zzfg, this.zzfh, this.zzfi, j, this.zzfk, this.zzfl, this.zzfm, this.zzfn, this.zzfo);
        return zzae;
    }

    /* access modifiers changed from: 0000 */
    public final zzae zza(long j, long j2) {
        zzae zzae = new zzae(this.zzce, this.name, this.zzfg, this.zzfh, this.zzfi, this.zzfj, j, Long.valueOf(j2), this.zzfm, this.zzfn, this.zzfo);
        return zzae;
    }

    /* access modifiers changed from: 0000 */
    public final zzae zza(Long l, Long l2, Boolean bool) {
        zzae zzae = new zzae(this.zzce, this.name, this.zzfg, this.zzfh, this.zzfi, this.zzfj, this.zzfk, this.zzfl, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
        return zzae;
    }
}
