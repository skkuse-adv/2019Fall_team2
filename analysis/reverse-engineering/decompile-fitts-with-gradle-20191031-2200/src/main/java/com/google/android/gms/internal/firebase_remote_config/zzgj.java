package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public abstract class zzgj {
    int zzpd;
    int zzpe;
    int zzpf;
    zzgq zzpg;

    static zzgj zza(byte[] bArr, int i, int i2, boolean z) {
        zzgl zzgl = new zzgl(bArr, 0, i2, false);
        try {
            zzgl.zzaa(i2);
            return zzgl;
        } catch (zzhq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzac(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zze(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzaa(int i) throws zzhq;

    public abstract void zzab(int i);

    public abstract int zzfb() throws IOException;

    public abstract long zzfc() throws IOException;

    public abstract long zzfd() throws IOException;

    public abstract int zzfe() throws IOException;

    public abstract long zzff() throws IOException;

    public abstract int zzfg() throws IOException;

    public abstract boolean zzfh() throws IOException;

    public abstract String zzfi() throws IOException;

    public abstract zzfx zzfj() throws IOException;

    public abstract int zzfk() throws IOException;

    public abstract int zzfl() throws IOException;

    public abstract int zzfm() throws IOException;

    public abstract long zzfn() throws IOException;

    public abstract int zzfo() throws IOException;

    public abstract long zzfp() throws IOException;

    public abstract boolean zzfr() throws IOException;

    public abstract int zzfs();

    public abstract void zzy(int i) throws zzhq;

    public abstract boolean zzz(int i) throws IOException;

    private zzgj() {
        this.zzpe = 100;
        this.zzpf = Integer.MAX_VALUE;
    }
}
