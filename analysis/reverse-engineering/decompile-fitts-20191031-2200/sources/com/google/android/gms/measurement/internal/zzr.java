package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

public final class zzr {
    zzr(Context context) {
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
