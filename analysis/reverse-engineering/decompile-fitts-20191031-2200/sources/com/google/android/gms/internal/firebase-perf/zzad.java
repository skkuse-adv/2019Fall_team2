package com.google.android.gms.internal.firebase-perf;

final class zzad extends zzr<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzz;

    zzad(Object[] objArr, int i, int i2) {
        this.zzz = objArr;
        this.offset = i;
        this.size = i2;
    }

    public final Object get(int i) {
        zzf.zza(i, this.size);
        return this.zzz[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
