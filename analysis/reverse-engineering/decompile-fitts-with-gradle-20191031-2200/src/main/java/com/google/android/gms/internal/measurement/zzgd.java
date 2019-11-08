package com.google.android.gms.internal.measurement;

final class zzgd {
    private static final zzgb zzakf = zzvq();
    private static final zzgb zzakg = new zzge();

    static zzgb zzvo() {
        return zzakf;
    }

    static zzgb zzvp() {
        return zzakg;
    }

    private static zzgb zzvq() {
        try {
            return (zzgb) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
