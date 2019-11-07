package com.google.android.gms.internal.firebase-perf;

final class zzdj {
    private static final Class<?> zzmq = zzae("libcore.io.Memory");
    private static final boolean zzmr = (zzae("org.robolectric.Robolectric") != null);

    static boolean zzgc() {
        return zzmq != null && !zzmr;
    }

    static Class<?> zzgd() {
        return zzmq;
    }

    private static <T> Class<T> zzae(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
