package com.google.android.gms.internal.measurement;

final class zzdi {
    private static final Class<?> zzacx = zzdp("libcore.io.Memory");
    private static final boolean zzacy = (zzdp("org.robolectric.Robolectric") != null);

    static boolean zzrv() {
        return zzacx != null && !zzacy;
    }

    static Class<?> zzrw() {
        return zzacx;
    }

    private static <T> Class<T> zzdp(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
