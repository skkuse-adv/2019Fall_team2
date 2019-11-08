package com.google.android.gms.internal.firebase-perf;

final class zzgi {
    private static final zzgg zzts = zzin();
    private static final zzgg zztt = new zzgf();

    static zzgg zzil() {
        return zzts;
    }

    static zzgg zzim() {
        return zztt;
    }

    private static zzgg zzin() {
        try {
            return (zzgg) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
