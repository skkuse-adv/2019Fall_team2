package com.google.android.gms.internal.firebase_remote_config;

final class zzja {
    private static final zziy zzwi = zzih();
    private static final zziy zzwj = new zzix();

    static zziy zzif() {
        return zzwi;
    }

    static zziy zzig() {
        return zzwj;
    }

    private static zziy zzih() {
        try {
            return (zziy) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
