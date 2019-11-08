package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import java.io.IOException;
import java.io.InputStream;

public final class zza extends InputStream {
    private final zzbg zzfy;
    private final InputStream zzgl;
    private final zzau zzgm;
    private long zzgn = -1;
    private long zzgo;
    private long zzgp = -1;

    public zza(InputStream inputStream, zzau zzau, zzbg zzbg) {
        this.zzfy = zzbg;
        this.zzgl = inputStream;
        this.zzgm = zzau;
        this.zzgo = this.zzgm.zzag();
    }

    public final int available() throws IOException {
        try {
            return this.zzgl.available();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void close() throws IOException {
        long zzcs = this.zzfy.zzcs();
        if (this.zzgp == -1) {
            this.zzgp = zzcs;
        }
        try {
            this.zzgl.close();
            if (this.zzgn != -1) {
                this.zzgm.zzk(this.zzgn);
            }
            if (this.zzgo != -1) {
                this.zzgm.zzi(this.zzgo);
            }
            this.zzgm.zzj(this.zzgp);
            this.zzgm.zzai();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void mark(int i) {
        this.zzgl.mark(i);
    }

    public final boolean markSupported() {
        return this.zzgl.markSupported();
    }

    public final int read() throws IOException {
        try {
            int read = this.zzgl.read();
            long zzcs = this.zzfy.zzcs();
            if (this.zzgo == -1) {
                this.zzgo = zzcs;
            }
            if (read == -1 && this.zzgp == -1) {
                this.zzgp = zzcs;
                this.zzgm.zzj(this.zzgp);
                this.zzgm.zzai();
            } else {
                this.zzgn++;
                this.zzgm.zzk(this.zzgn);
            }
            return read;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.zzgl.read(bArr, i, i2);
            long zzcs = this.zzfy.zzcs();
            if (this.zzgo == -1) {
                this.zzgo = zzcs;
            }
            if (read == -1 && this.zzgp == -1) {
                this.zzgp = zzcs;
                this.zzgm.zzj(this.zzgp);
                this.zzgm.zzai();
            } else {
                this.zzgn += (long) read;
                this.zzgm.zzk(this.zzgn);
            }
            return read;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.zzgl.read(bArr);
            long zzcs = this.zzfy.zzcs();
            if (this.zzgo == -1) {
                this.zzgo = zzcs;
            }
            if (read == -1 && this.zzgp == -1) {
                this.zzgp = zzcs;
                this.zzgm.zzj(this.zzgp);
                this.zzgm.zzai();
            } else {
                this.zzgn += (long) read;
                this.zzgm.zzk(this.zzgn);
            }
            return read;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void reset() throws IOException {
        try {
            this.zzgl.reset();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.zzgl.skip(j);
            long zzcs = this.zzfy.zzcs();
            if (this.zzgo == -1) {
                this.zzgo = zzcs;
            }
            if (skip == -1 && this.zzgp == -1) {
                this.zzgp = zzcs;
                this.zzgm.zzj(this.zzgp);
            } else {
                this.zzgn += skip;
                this.zzgm.zzk(this.zzgn);
            }
            return skip;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }
}
