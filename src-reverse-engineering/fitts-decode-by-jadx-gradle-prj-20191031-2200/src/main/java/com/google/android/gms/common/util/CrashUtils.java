package com.google.android.gms.common.util;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class CrashUtils {
    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        return zza(context, th, 536870912);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
        } catch (Exception unused) {
        }
        return false;
    }

    static {
        new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    }
}
