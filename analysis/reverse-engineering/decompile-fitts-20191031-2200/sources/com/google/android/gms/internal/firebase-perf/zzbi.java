package com.google.android.gms.internal.firebase-perf;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.net.URI;

public final class zzbi {
    private static String[] zzia;

    public static boolean zza(@NonNull URI uri, @NonNull Context context) {
        String[] strArr;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier <= 0) {
            return true;
        }
        if (zzia == null) {
            zzia = resources.getStringArray(identifier);
        }
        for (String str : zzia) {
            String host = uri.getHost();
            if (host == null || host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
