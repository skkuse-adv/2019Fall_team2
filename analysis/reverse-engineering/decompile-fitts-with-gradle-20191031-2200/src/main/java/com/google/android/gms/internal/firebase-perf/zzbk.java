package com.google.android.gms.internal.firebase-perf;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.NonNull;
import kotlin.UByte;

public final class zzbk {
    private static Boolean zzib;

    public static int zza(@NonNull byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4 && i < bArr.length) {
            i2 |= (bArr[i] & UByte.MAX_VALUE) << (i << 3);
            i++;
        }
        return i2;
    }

    public static boolean zzg(@NonNull Context context) {
        Boolean bool = zzib;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            zzib = valueOf;
            return valueOf.booleanValue();
        } catch (NameNotFoundException | NullPointerException e) {
            String str = "No perf logcat meta data found ";
            String valueOf2 = String.valueOf(e.getMessage());
            if (valueOf2.length() != 0) {
                str.concat(valueOf2);
            } else {
                new String(str);
            }
            return false;
        }
    }
}
