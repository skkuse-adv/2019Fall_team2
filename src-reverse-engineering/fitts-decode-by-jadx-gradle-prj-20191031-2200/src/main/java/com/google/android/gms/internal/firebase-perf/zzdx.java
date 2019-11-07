package com.google.android.gms.internal.firebase-perf;

public abstract class zzdx {
    static zzdx zza(byte[] bArr, int i, int i2, boolean z) {
        zzdz zzdz = new zzdz(bArr, 0, i2, false);
        try {
            zzdz.zzt(i2);
            return zzdz;
        } catch (zzex e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzgn();

    public abstract int zzt(int i) throws zzex;

    private zzdx() {
    }
}
