package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzaw;
import java.util.Locale;
import java.util.Map.Entry;

public abstract class zzr {
    public abstract boolean zzbe();

    public static String zzf(@Nullable String str) {
        if (str == null) {
            return "Metric name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Metric name must not exceed %d characters", new Object[]{Integer.valueOf(100)});
        } else if (!str.startsWith("_")) {
            return null;
        } else {
            for (zzaw zzaw : zzaw.values()) {
                if (zzaw.toString().equals(str)) {
                    return null;
                }
            }
            return "Metric name must not start with '_'";
        }
    }

    public static String zza(@NonNull Entry<String, String> entry) {
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        if (str == null) {
            return "Attribute key must not be null";
        }
        if (str2 == null) {
            return "Attribute value must not be null";
        }
        if (str.length() > 40) {
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", new Object[]{Integer.valueOf(40)});
        } else if (str2.length() > 100) {
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", new Object[]{Integer.valueOf(100)});
        } else if (!str.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
        } else {
            return null;
        }
    }
}
