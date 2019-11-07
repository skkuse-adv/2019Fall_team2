package com.google.android.gms.measurement.internal;

import java.util.Map;

final /* synthetic */ class zzhm implements Runnable {
    private final zzhn zzqh;
    private final int zzqi;
    private final Exception zzqj;
    private final byte[] zzqk;
    private final Map zzql;

    zzhm(zzhn zzhn, int i, Exception exc, byte[] bArr, Map map) {
        this.zzqh = zzhn;
        this.zzqi = i;
        this.zzqj = exc;
        this.zzqk = bArr;
        this.zzql = map;
    }

    public final void run() {
        this.zzqh.zzb(this.zzqi, this.zzqj, this.zzqk, this.zzql);
    }
}
