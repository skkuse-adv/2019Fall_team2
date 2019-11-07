package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

@WorkerThread
final class zzek implements Runnable {
    private final Throwable exception;
    private final String packageName;
    private final int status;
    private final zzel zzkv;
    private final byte[] zzkw;
    private final Map<String, List<String>> zzkx;

    private zzek(String str, zzel zzel, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzel);
        this.zzkv = zzel;
        this.status = i;
        this.exception = th;
        this.zzkw = bArr;
        this.packageName = str;
        this.zzkx = map;
    }

    public final void run() {
        this.zzkv.zza(this.packageName, this.status, this.exception, this.zzkw, this.zzkx);
    }
}
