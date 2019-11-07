package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import java.io.IOException;
import java.io.OutputStream;

public final class zzc extends OutputStream {
    private final zzbg zzfy;
    private zzau zzgm;
    private OutputStream zzgr;
    private long zzgs = -1;

    public zzc(OutputStream outputStream, zzau zzau, zzbg zzbg) {
        this.zzgr = outputStream;
        this.zzgm = zzau;
        this.zzfy = zzbg;
    }

    public final void close() throws IOException {
        long j = this.zzgs;
        if (j != -1) {
            this.zzgm.zzf(j);
        }
        this.zzgm.zzh(this.zzfy.zzcs());
        try {
            this.zzgr.close();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void flush() throws IOException {
        try {
            this.zzgr.flush();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void write(int i) throws IOException {
        try {
            this.zzgr.write(i);
            this.zzgs++;
            this.zzgm.zzf(this.zzgs);
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.zzgr.write(bArr);
            this.zzgs += (long) bArr.length;
            this.zzgm.zzf(this.zzgs);
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzgr.write(bArr, i, i2);
            this.zzgs += (long) i2;
            this.zzgm.zzf(this.zzgs);
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }
}
