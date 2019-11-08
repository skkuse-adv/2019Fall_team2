package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.firebase-perf.zzah;
import com.google.android.gms.internal.firebase-perf.zzba;
import java.util.Iterator;
import java.util.List;

final class zzp {
    private final Runtime zzbh;
    private final ActivityManager zzdy;
    private final MemoryInfo zzdz;
    private final String zzea;
    private final Context zzeb;

    zzp(Context context) {
        this(Runtime.getRuntime(), context);
    }

    @VisibleForTesting
    private zzp(Runtime runtime, Context context) {
        String str;
        this.zzbh = runtime;
        this.zzeb = context;
        this.zzdy = (ActivityManager) context.getSystemService("activity");
        this.zzdz = new MemoryInfo();
        this.zzdy.getMemoryInfo(this.zzdz);
        int myPid = Process.myPid();
        List runningAppProcesses = this.zzdy.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                    break;
                }
            }
            this.zzea = str;
        }
        str = this.zzeb.getPackageName();
        this.zzea = str;
    }

    public final String getProcessName() {
        return this.zzea;
    }

    public final int zzbj() {
        return zzah.zza(zzba.BYTES.zzp(this.zzbh.maxMemory()));
    }

    public final int zzbk() {
        return zzah.zza(zzba.MEGABYTES.zzp((long) this.zzdy.getMemoryClass()));
    }

    public final int zzbl() {
        return zzah.zza(zzba.BYTES.zzp(this.zzdz.totalMem));
    }
}
