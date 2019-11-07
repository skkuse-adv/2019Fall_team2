package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzfj;

public class Analytics {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile Analytics zzub;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static Analytics getInstance(Context context) {
        if (zzub == null) {
            synchronized (Analytics.class) {
                if (zzub == null) {
                    zzub = new Analytics(zzfj.zza(context, (zzx) null));
                }
            }
        }
        return zzub;
    }

    private Analytics(zzfj zzfj) {
        Preconditions.checkNotNull(zzfj);
    }
}
