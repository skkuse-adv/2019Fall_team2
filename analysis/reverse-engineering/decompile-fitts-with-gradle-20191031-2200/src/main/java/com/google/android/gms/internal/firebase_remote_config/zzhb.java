package com.google.android.gms.internal.firebase_remote_config;

final class zzhb {
    private static final zzgz<?> zzqj = new zzgy();
    private static final zzgz<?> zzqk = zzgk();

    private static zzgz<?> zzgk() {
        try {
            return (zzgz) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzgz<?> zzgl() {
        return zzqj;
    }

    static zzgz<?> zzgm() {
        zzgz<?> zzgz = zzqk;
        if (zzgz != null) {
            return zzgz;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
