package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzeb {
    int zzadp;
    int zzadq;
    zzec zzads;

    public static int zzaz(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzbm(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzeb zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzgi> T zza(zzgr<T> zzgr, zzel zzel) throws IOException;

    public abstract void zzat(int i) throws zzfi;

    public abstract boolean zzau(int i) throws IOException;

    public abstract int zzaw(int i) throws zzfi;

    public abstract void zzax(int i);

    public abstract void zzay(int i) throws IOException;

    public abstract int zzsg() throws IOException;

    public abstract long zzsh() throws IOException;

    public abstract long zzsi() throws IOException;

    public abstract int zzsj() throws IOException;

    public abstract long zzsk() throws IOException;

    public abstract int zzsl() throws IOException;

    public abstract boolean zzsm() throws IOException;

    public abstract String zzsn() throws IOException;

    public abstract zzdp zzso() throws IOException;

    public abstract int zzsp() throws IOException;

    public abstract int zzsq() throws IOException;

    public abstract int zzsr() throws IOException;

    public abstract long zzss() throws IOException;

    public abstract int zzst() throws IOException;

    public abstract long zzsu() throws IOException;

    public abstract boolean zzsw() throws IOException;

    public abstract int zzsx();

    static zzeb zza(byte[] bArr, int i, int i2, boolean z) {
        zzed zzed = new zzed(bArr, i, i2, false);
        try {
            zzed.zzaw(i2);
            return zzed;
        } catch (zzfi e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzeb() {
        this.zzadq = 100;
    }

    public final int zzav(int i) {
        if (i >= 0) {
            int i2 = this.zzadq;
            this.zzadq = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
