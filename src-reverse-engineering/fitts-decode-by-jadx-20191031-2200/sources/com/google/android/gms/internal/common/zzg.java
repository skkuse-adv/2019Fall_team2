package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;

public final class zzg {
    public static boolean zzam() {
        return VERSION.SDK_INT >= 24;
    }

    @RequiresApi(24)
    @TargetApi(24)
    public static Context getDeviceProtectedStorageContext(Context context) {
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }

    static {
        zzam();
    }
}
