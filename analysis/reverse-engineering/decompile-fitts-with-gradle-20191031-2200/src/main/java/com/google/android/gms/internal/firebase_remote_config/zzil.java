package com.google.android.gms.internal.firebase_remote_config;

final class zzil {
    private static final zzij zzvn = zzia();
    private static final zzij zzvo = new zzim();

    static zzij zzhy() {
        return zzvn;
    }

    static zzij zzhz() {
        return zzvo;
    }

    private static zzij zzia() {
        try {
            return (zzij) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
