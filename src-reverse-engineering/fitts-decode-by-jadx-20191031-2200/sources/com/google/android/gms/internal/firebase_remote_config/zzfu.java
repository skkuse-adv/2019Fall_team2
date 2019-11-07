package com.google.android.gms.internal.firebase_remote_config;

final class zzfu {
    private static final Class<?> zzon = zzbi("libcore.io.Memory");
    private static final boolean zzoo = (zzbi("org.robolectric.Robolectric") != null);

    static boolean zzeu() {
        return zzon != null && !zzoo;
    }

    static Class<?> zzev() {
        return zzon;
    }

    private static <T> Class<T> zzbi(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
