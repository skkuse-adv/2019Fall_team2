package com.google.android.gms.internal.firebase-perf;

final class zzfw {
    private static final zzfu zzsx = zzij();
    private static final zzfu zzsy = new zzft();

    static zzfu zzih() {
        return zzsx;
    }

    static zzfu zzii() {
        return zzsy;
    }

    private static zzfu zzij() {
        try {
            return (zzfu) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
