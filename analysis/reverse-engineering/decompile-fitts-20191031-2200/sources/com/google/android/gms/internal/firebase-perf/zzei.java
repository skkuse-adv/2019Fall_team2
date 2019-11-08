package com.google.android.gms.internal.firebase-perf;

final class zzei {
    private static final zzeg<?> zznt = new zzef();
    private static final zzeg<?> zznu = zzgw();

    private static zzeg<?> zzgw() {
        try {
            return (zzeg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzeg<?> zzgx() {
        return zznt;
    }

    static zzeg<?> zzgy() {
        zzeg<?> zzeg = zznu;
        if (zzeg != null) {
            return zzeg;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
